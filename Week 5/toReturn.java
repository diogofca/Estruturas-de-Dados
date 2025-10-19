
class BigNumber {
    protected int[] digits;

    BigNumber(String number) {
        this.digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            this.digits[i] = (number.charAt(number.length() - 1 - i) - '0');
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
        for (int i = size() - 1; i >= 0; i--) {
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
                // System.out.println(String.format("%d", (otherNumber[i] + n.digits[i] +
                // goesOne) % 10));
                // System.out.println(goesOne);
            }
            if (goesOne > 0) {
                toReturn.append(String.format("%d", goesOne));
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
            if (goesOne > 0) {
                toReturn.append(String.format("%d", goesOne));
            }

        }

        return new BigNumber(toReturn.reverse().toString());
    }

    public BigNumber multiply(BigNumber n) {
        BigNumber[] toReturnList = new BigNumber[n.size()];
        for (int i = 0; i < n.size(); i++) {
            StringBuilder toAdd = new StringBuilder();
            int constant = n.digits[i];
            // System.out.println(constant);
            int goes = 0;
            for (int k = 0; k < i; k++) {
                toAdd.append("0");
            }
            for (int j = 0; j < this.size(); j++) {
                // System.out.println(constant * this.digits[j] + goes);
                int lala = (constant * this.digits[j] + goes) % 10;
                goes = (constant * this.digits[j] + goes) / 10;
                toAdd.append(String.format("%d", lala));
                // System.out.println(goes);
                // System.out.println(lala);
            }
            if (goes > 0) {
                toAdd.append(String.format("%d", goes));
            }
            toReturnList[i] = new BigNumber(toAdd.reverse().toString());
            // System.out.println(toReturnList[i]);
        }

        BigNumber toReturn = toReturnList[0].add(toReturnList[1]);
        // System.out.println(toReturn);
        for (int i = 2; i < toReturnList.length; i++) {
            // System.out.println(toReturnList[i]);
            toReturn = toReturn.add(toReturnList[i]);
            // System.out.println(toReturn);

        }

        return toReturn;

    }
}
