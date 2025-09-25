class Point {
    int x, y;

    Point() {
        x = y = 0;
    }

    Point(int x0, int y0) {
        x = x0;
        y = y0;
    }

    // Devolve uma representação em texto do conteúdo de um Ponto
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class Rectangle {
    Point left;
    Point right;

    Rectangle(int x1, int y1, int x2, int y2) {
        left = new Point(x1, y1);
        right = new Point(x2, y2);
    }

    Rectangle(Point p1, Point p2) {
        left = p1;
        right = p2;
    }

    public int area() {
        return (right.x - left.x) * (right.y - left.y);
    }

    public int perimeter() {
        // System.out.println(right.x);
        // System.out.println(right.x - left.x);
        // System.out.println(right.y - right.x);
        return 2 * (right.x - left.x) + 2 * (right.y - left.y);
    }

    public boolean pointInside(Point p) {
        return (left.x <= p.x && p.x <= right.x) && (left.y <= p.y && p.y <= right.y);
    }

    public boolean rectangleInside(Rectangle r) {
        return this.pointInside(r.left) && this.pointInside(r.right);
    }
}

class TestRectangle {
    public static void main(String[] args) {
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        Point c = new Point(3, 4);
        Point d = new Point(8, 2);

        Rectangle amarelo = new Rectangle(a, c);
        Rectangle laranja = new Rectangle(2, 3, 9, 6);
        Rectangle verde = new Rectangle(3, 4, 4, 5);
        Rectangle azul = new Rectangle(5, 1, 6, 5);
        Rectangle vermelho = new Rectangle(7, 3, 9, 5);

        System.out.println("Perimetro do retangulo amarelo = " + amarelo.perimeter()); // 10
        System.out.println("Perimetro do retangulo laranja = " + laranja.perimeter()); // 20

        System.out.println("Area do retangulo amarelo = " + amarelo.area()); // 6
        System.out.println("Area do retangulo laranja = " + laranja.area()); // 21

        System.out.println("Ponto B dentro rectangulo amarelo? " + amarelo.pointInside(b)); // true
        System.out.println("Ponto D dentro rectangulo amarelo? " + amarelo.pointInside(d)); // false

        System.out.println("Retangulo verde dentro do laranja? " + laranja.rectangleInside(verde)); // true
        System.out.println("Retangulo azul dentro do laranja? " + laranja.rectangleInside(azul)); // false
        System.out.println("Retangulo vermelho dentro do laranja? " + laranja.rectangleInside(vermelho)); // true
    }
}