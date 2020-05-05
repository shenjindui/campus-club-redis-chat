new Vue({
    el: '#app',
    data() {
        return {
            dialog: true,
            avatarDialog: false,
            form: {},
            avatarList: [],
        }
    },
    created () {
       /* let userInfo2=this.fetchIDlist("userInfo");
        if(userInfo2.realname==null||userInfo2.realname===''||userInfo2.realname==='undefined'){
            this.form.name='系统用户'+this.createRomdomNumber(25);
        }else{
            this.form.name=userInfo2.realname;
        }*/
    },
    mounted() {
        this.$refs.loader.style.display = 'none';
    },
    methods: {
        createRomdomNumber(n){
            var res = 0;
            for(var i = 0; i < n ; i ++) {
                var id = Math.ceil(Math.random()*35);
                res += id;
            }
            return res;
        },
        fetchIDlist(IDLIST_KEY) {
            return JSON.parse(window.localStorage.getItem(IDLIST_KEY) || '[]');
        },
        handleEditAvatar() {
            this.$http.get(api.getAvatarList()).then(response => {
                this.avatarList = response.body;
            });
            this.avatarDialog = true;
        },
        changeAvatar(url) {
            this.form.avatar = url;
            this.avatarDialog = false;
        },

        login(form) {
            this.$refs[form].validate(valid => {
                if (valid) {
                    if (this.form.avatar == null || this.form.avatar == '') {
                        this._notify('请选择头像', 'warning')
                        return;
                    }
                    this.form.id = new Date().getTime();
                    this.$http.post(api.login(), JSON.stringify(this.form)).then(response => {
                        console.log(response)
                        if (response.body.code == 200) {
                            window.location.href = api.redirect(this.form.id)
                        } else {
                            this.$message({
                                message: "用户名校验失败!",
                                type: 'error'
                            })
                        }
                    })
                } else {
                    return false;
                }
            })
        },
        back(){
            this.$http.delete(api.logout(this.form.id)).then(response => {
                //this.websocket.close()
            /*window.location.href = "http://localhost:8081/#/chatroom/";*/
            window.location.href = "http://106.54.55.188:8081/#/chatroom/";
        })

        }
    }
})
