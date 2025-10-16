public class TestED248 {
	public static void main(String[] args) {
		int n = 1000000;
		IntSet s1 = new BooleanArrayIntSet(n); // Criar array de booleanos para numeros no intervalo [1,n]
		System.out.println(s1.size());
		System.out.println(s1.add(10));
		System.out.println(s1.add(5));
		System.out.println(s1.add(20));
		System.out.println(s1.add(130));

	}
}

interface IntSet {
	public boolean contains(int x); // Retorna true se x esta no conjunto

	public boolean add(int x); // Adiciona x ao conjunto (devolve true se conseguir)

	public boolean remove(int x); // Remove x do conjunto (devolve true se conseguir)

	public int size(); // Retorna o numero de elementos do conjunto

	public void clear(); // Limpa o conjunto (torna-o vazio)

	public boolean equals(IntSet s); // Retorna true se ambos os conjuntos sao iguais

	public IntSet intersection(IntSet s); // devolve um novo conjunto: a intersecao de ambos
}

class BooleanArrayIntSet implements IntSet {
	// Deverá colocar aqui os atributos e métodos
	private boolean[] elems;
	private int size;

	BooleanArrayIntSet(int n) {
		this.elems = new boolean[n + 1];
		this.size = 0;
	}

	public IntSet intersection(IntSet s) {
		BooleanArrayIntSet toReturn = new BooleanArrayIntSet(this.elems.length);
		for (int i = 0; i < this.elems.length; i++) {
			if (this.contains(i) && s.contains(i)) {
				toReturn.add(i);
			}
		}
		return toReturn;
	}

	public boolean equals(IntSet s) {
		for (int i = 0; i < this.elems.length; i++) {
			if (this.elems[i]) {
				if (!s.contains(i)) {
					return false;
				}
			}
		}
		return this.size == s.size();
	}

	public void clear() {
		for (int i = 0; i < this.elems.length; i++) {
			this.elems[i] = false;
		}
		size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean contains(int x) {
		return this.elems[x];
	}

	public boolean add(int x) {
		if (this.elems[x] == true) {
			return false;
		}
		try {
			this.elems[x] = true;
			size += 1;
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean remove(int x) {
		if (this.elems[x] == false) {
			return false;
		}
		try {
			this.elems[x] = false;
			size -= 1;
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

}
