package networkmodel;

public class PQ<E extends Comparable<E>> {
	private int size;
	private E[] heap;

	public PQ() {
		size = 0;
		heap = (E[]) new Comparable[20];
	}

	public void add(E e) {
		int pos = ++size;

		for (; pos > 1 && e.compareTo(heap[parent(pos)]) < 0; pos = parent(pos)) {
			heap[pos] = heap[parent(pos)];
		}
		heap[pos] = e;
	}

	public E peek() {
		E min = heap[1];
		return min;
	}

	public E poll() {
		E min = heap[1];
		heap[1] = heap[size--];
		moveDown(1);
		return min;
	}

	private void moveDown(int k) {
		E temp = heap[k];
		int child;

		for (; left(k) <= size; k = child) {
			child = left(k);

			if (child != size && heap[child].compareTo(heap[child + 1]) > 0) {
				child++;
			}

			if (temp.compareTo(heap[child]) > 0) {
				heap[k] = heap[child];
			} else {
				break;
			}
		}
		heap[k] = temp;
	}

	public boolean isEmpty() {
		return size > 0 ? false : true;
	}

	public int parent(int pos) {
		return pos / 2;
	}

	public int left(int pos) {
		return 2 * pos;
	}

	public int right(int pos) {
		return 2 * pos + 1;
	}
}
