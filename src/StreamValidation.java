class StreamValidation {
    boolean streamValidation(int[] stream) {
        String[] str = new String[stream.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = getBinary(stream[i]);
        }
        int idx = 0;
        while (idx < str.length) {
            int type = getCase(str[idx]);
            boolean ok = validateType(type, str, idx);
            if (!ok) {
                return false;
            } else {
                idx += type;
            }
        }
        return true;
    }

    String getBinary(int i) {
        String ret = Integer.toString(i, 2);
        if (ret.length() == 8) {
            return ret;
        } else {
            int toAdd = 8 - ret.length();
            String pref = "";
            while (toAdd > 0) {
                pref += "0";
                toAdd--;
            }
            return pref + ret;
        }
    }

    int getCase(String s) {
        if (s.charAt(0) == '0') {
            return 1;
        } else if (s.substring(0, 3).equals("110")) {
            return 2;
        } else if (s.substring(0, 4).equals("1110")) {
            return 3;
        } else if (s.substring(0, 5).equals("11110")) {
            return 4;
        } else {
            return -1;
        }
    }

    boolean validateType(int type, String[] str, int idx) {
        if (type == -1) {
            return false;
        } else if (type == 1) {
            return true;
        } else {
            int count = 0;
            for (int i = idx + 1; i < type + idx && i < str.length; i++) {
                if (!str[i].substring(0, 2).equals("10")) {
                    return false;
                }
                count++;
            }
            if (count != type - 1) {
                return false;
            }
        }
        return true;
    }
}