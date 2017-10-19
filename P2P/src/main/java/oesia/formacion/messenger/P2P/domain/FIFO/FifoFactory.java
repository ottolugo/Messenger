package oesia.formacion.messenger.P2P.domain.FIFO;

public class FifoFactory {

	private static FifoStack fifo = null;

	public static FifoStack getFifo() {
		if (fifo == null) {
			fifo = new FifoStack();
		}
		return fifo;
	}

}
