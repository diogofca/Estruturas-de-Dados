public class TestBigNumber {
    public static void main(String[] args) {
        BigNumber n1 = new BigNumber("1234567890");
        System.out.println(n1); // Escreve "1234567890"

        BigNumber n2 = new BigNumber("42");
        BigNumber n3 = new BigNumber("1234567890");
        System.out.println(n1.equals(n2)); // Escreve "false"
        System.out.println(n1.equals(n3)); // Escreve "true"

        BigNumber n4 = new BigNumber("46711237126582920746212");
        BigNumber n5 = new BigNumber("8765432110");
        BigNumber n6 = n1.add(n3);
        System.out.println(n6); // Escreve "2469135780"
        BigNumber n7 = n1.add(n4);
        System.out.println(n7); // Escreve "46711237126584155314102"
        BigNumber n8 = n1.add(n5);
        System.out.println(n8); // Escreve "10000000000"

        // BigNumber n9 = n1.multiply(n3);
        // System.out.println(n9); // Escreve "1524157875019052100"
        // BigNumber n10 = n1.multiply(n4);
        // System.out.println(n10); // Escreve "57668193458655139375688174332680"
    }
}

class BigNumber {
    protected int[] digits;

    BigNumber(String number) {
        this.digits = new int[number.length()];
        for (int i = 0; i < digits.length; i++) {
            this.digits[i] = (number.charAt(number.length() - i) - '0');
        }
    }

    protected int size() {
        return this.digits.length;
    }

    public boolean equals(BigNumber n) {
        if (n.size() != this.size()) {
            return false;
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (this.digits[i] != n.digits[i]) {
                    return false;
                }
            }
            return true;
        }

    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            toReturn.append(String.format("%d", this.digits[i]));
        }
        return toReturn.toString();
    }

    public BigNumber add(BigNumber n) {
        StringBuilder toReturn = new StringBuilder();

        if (n.size() > this.size()) {
            int[] otherNumber = new int[n.size()];
            for (int i = 0; i < this.size(); i++) {
                otherNumber[i] = this.digits[i];
            }

            // já tenho as coisas iguais
            int goesOne = 0;
            for (int i = 0; i < n.size(); i++) {
                toReturn.append(String.format("%d", (otherNumber[i] + n.digits[i] + goesOne) % 10));
                goesOne = (otherNumber[i] + n.digits[i] + goesOne) / 10;
            }
            if (goesOne == 1) {
                toReturn.append("1");
            }

        } else {
            int[] otherNumber = new int[this.size()];
            for (int i = 0; i < n.size(); i++) {
                otherNumber[i] = n.digits[i];
            }
            int goesOne = 0;
            for (int i = 0; i < n.size(); i++) {
                toReturn.append(String.format("%d", (otherNumber[i] + this.digits[i] + goesOne) % 10));
                goesOne = (otherNumber[i] + this.digits[i] + goesOne) / 10;
            }
            if (goesOne == 1) {
                toReturn.append("1");
            }

        }

        return new BigNumber(toReturn.toString());
    }
}
