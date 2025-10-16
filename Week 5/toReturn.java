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
