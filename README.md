# Messenger

There are two folders, each one is a different maven proyect
GUI:
  This is the user interface. We used javafx for the design. With java we made a model and conversors.
  Also user observer pattern to develop this part of the app.
  If you dont select any user message with be sent in broadcast, also can select all using the buttom "Todos"
  If you select one user the message will apear in user GUI.
  
P2P:
  We decided to call it this way because all user are client and server.
  All messages sent in the net will be read by the p2p, but if they are no sent to us, the p2p will not set it to the GUI.
  
