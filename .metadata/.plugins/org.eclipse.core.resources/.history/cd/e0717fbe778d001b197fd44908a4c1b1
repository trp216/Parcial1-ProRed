package control;

import java.util.UUID;

import com.google.gson.Gson;

import comm.Receptor.OnMessageListener;
import comm.TCPConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Hit;
import model.Card;
import model.Generic;
import model.Identification;
import model.Stand;
import model.Status;
import view.PlayerWindow;

public class PlayerController implements TCPConnection.OnConnectionListener, OnMessageListener{

	private PlayerWindow view;
	private TCPConnection connection;

	private Identification myID;

	private int score;

	public PlayerController(PlayerWindow view) {
		this.view = view;
		init();
	}

	public void init() {
		connection = TCPConnection.getInstance();
		connection.setConnectionListener(this);


		connection.setIp("127.0.0.1");
		connection.setPuerto(5000);
		connection.start();


	}

	@Override
	public void onConnection() {
		//start game
		view.setStatus("Conectado y esperando adversario");
		view.startGame();
		//dile al server que ya estas pa que te mande cartitas

		connection.setListenerOfMessages(this);
		//hit();
		view.getTakeCardButton().setOnAction( 
				(e) -> {
					hit();
				}
				);
		//stand();
		view.getStand().setOnAction( 
				(e) -> {
					stand();
				}
				);
	}

	@Override
	public void OnMessage(String msg) {
		Gson gson = new Gson();
		Generic type = gson.fromJson(msg, Generic.class);

		switch (type.getType()) {
		case "Identification":
			Identification i = gson.fromJson(msg, Identification.class);
			myID = i;
			System.out.println(myID.getId());
			break;
		case "Card":
			//ME HAN DADO UNA CARTA

			Platform.runLater(	
					()->{
						view.setStatus("Tu turno");
					}

					);

			Card card = gson.fromJson(msg, Card.class);
			//System.out.println("Got a card!");
			card(card); //NOT FINISHED
			break;

		case "Status":
			//Gano? Pierdo? Empato?
			Status st = gson.fromJson(msg, Status.class);

			Platform.runLater(	
					()->{
						view.setStatus(st.getMsg());
					}

					);


			//System.out.println(st.getMsg());
			break;
		}

	}

	//solo de envio
	public void stand() {
		Stand s = new Stand(score); //Tenes que llevar la cuenta de la puntuacion hija, pa decirle al dealer
		s.setId(myID.getId());
		Gson gson = new Gson();
		String json = gson.toJson(s);
		connection.getEmisor().sendMessage(json);

		Platform.runLater(	
				()->{
					view.getTakeCardButton().setDisable(true);
					view.getStand().setDisable(true);
				}

				);
	}

	public void card(Card c) {
		score += c.getValue();
		Platform.runLater(	
				()->{
					view.setCard(c);

					view.setStatus("Es el turno de tu oponente...");

				}

				);
		if(score>21) {
			stand();
		}
	}

	//solo de envio
	public void hit() { //esto es pedir
		Hit d = new Hit();
		d.setId(myID.getId());
		Gson gson = new Gson();
		String json = gson.toJson(d);
		connection.getEmisor().sendMessage(json);
	}



}
