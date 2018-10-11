class ChessQueen {
    String[] chessQueen(String q) {
        ArrayList<String> list = new ArrayList<>();
        for (char c = 'a'; 'i' - c > 0; c = (char) ((int) c + 1)) {
            char qChar = q.charAt(0);
            int qInt = Integer.parseInt("" + q.charAt(1));
            for (int i = 1; i <= 8; i++) {
                if (qChar != c && qInt != i) {
                    if (Math.abs(qChar - c) != Math.abs(i - qInt)) {
                        list.add("" + c + i);
                    }
                }
            }
        }
        return list.toArray(new String[0]);
    }
}