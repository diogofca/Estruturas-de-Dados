public class Testar {
	public static void main(String[] args) {
		SinglyLinkedList<Character> l = new SinglyLinkedList<Character>();
		l.addLast('a');
		l.addLast('b');
		l.addLast('c');
		l.addLast('d');
		l.addLast('e');
		// l.addLast(42);
		// l.addLast(1);
		l.shift(2);
		System.out.println(l);

	}
}