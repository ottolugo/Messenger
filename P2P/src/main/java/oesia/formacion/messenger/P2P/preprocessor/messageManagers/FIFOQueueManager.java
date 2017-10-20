package oesia.formacion.messenger.P2P.preprocessor.messageManagers;

import oesia.formacion.messenger.P2P.preprocessor.queue.FIFOQueue;

public class FIFOQueueManager {
	private static FIFOQueue queue;
	public static FIFOQueue getFIFOQueue(){
		if(queue == null){
			queue = new FIFOQueue();
		}
		return queue;
	}
}
