package com.path.actions.common.notifications;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

import org.springframework.web.socket.server.standard.SpringConfigurator;

public class PathWebSocketConfigurator extends SpringConfigurator 
{
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) 
	{
		// intercept web socket handshake between client and endpoint
		// add the http session as a user property the the websocket session
		if (request != null && request.getHttpSession() != null) 
		{
			HttpSession httpSession = (HttpSession) request.getHttpSession();
			sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
		}
	}
}
