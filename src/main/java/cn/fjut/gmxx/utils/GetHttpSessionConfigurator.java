package cn.fjut.gmxx.utils;/**
 * Created by admin on 2020/4/9.
 */

/**
 * @author : shenjindui
 * @date : 2020-04-09 19:02
 **/
import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class GetHttpSessionConfigurator extends Configurator{
    @Override
    public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        if(httpSession != null){
            config.getUserProperties().put(HttpSession.class.getName(), httpSession);
        }
    }

}
