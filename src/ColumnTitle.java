class ColumnTitle {
    String columnTitle(int number) {
        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            int digit = number % 26;
            sb.append(getChar(digit));
            number /= 26;
            if (digit == 0)
                number--;
        }
        return sb.reverse().toString();
    }

    char getChar(int i) {
        if (i == 0)
            return 'Z';
        return (char) (i - 1 + (int) 'A');
    }
}