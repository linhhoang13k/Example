    public class FileSystem {

        int countNumber = 0;
        LinkedHashMap<String, FileSystem> subfile = new LinkedHashMap<String, FileSystem>();
    }

    String[] countAPI(String[] calls) {
        LinkedHashMap<String, FileSystem> file = new LinkedHashMap<String, FileSystem>();
        for (int i = 0; i < calls.length; i++) {
            String split[] = calls[i].split("/");

            FileSystem origin = file.get(split[1]) != null ? file.get(split[1]) : new FileSystem();
            origin.countNumber++;

            FileSystem subFileSystem = origin.subfile.get(split[2]) != null ? origin.subfile.get(split[2]) : new FileSystem();
            subFileSystem.countNumber++;

            FileSystem subsFileSystem = subFileSystem.subfile.get(split[3]) != null ? subFileSystem.subfile.get(split[3]) : new FileSystem();
            subsFileSystem.countNumber++;

            subFileSystem.subfile.put(split[3], subsFileSystem);
            origin.subfile.put(split[2], subFileSystem);

            file.put(split[1], origin);
        }
        ArrayList<String> result = new ArrayList<String>();
        for (Map.Entry m : file.entrySet()) {
            FileSystem origin = (FileSystem) m.getValue();
            result.add("--" + m.getKey() + " (" + Integer.toString(origin.countNumber) + ")");
            for (Map.Entry m2 : origin.subfile.entrySet()) {
                FileSystem sub = (FileSystem) m2.getValue();
                result.add("----" + m2.getKey() + " (" + Integer.toString(sub.countNumber) + ")");
                for (Map.Entry m3 : sub.subfile.entrySet()) {
                    FileSystem sub2 = (FileSystem) m3.getValue();
                    result.add("------" + m3.getKey() + " (" + Integer.toString(sub2.countNumber) + ")");
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }
