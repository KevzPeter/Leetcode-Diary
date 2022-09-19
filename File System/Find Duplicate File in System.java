// revisiting the first problem I ever solved on Leetcode through today's (19-8-22) daily challenge!
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (paths == null || paths.length == 0)
            return res;
        HashMap<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[][] fileData = getFileData(path);
            int n = fileData.length;
            for (int i = 0; i < n; i++) {
                String fileContent = fileData[i][0];
                String filePath = fileData[i][1];
                if (!map.containsKey(fileContent)) {
                    map.put(fileContent, new ArrayList<>());
                }
                map.get(fileContent).add(filePath);
            }
        }

        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            if (e.getValue().size() >= 2) {
                res.add(e.getValue());
            }
        }
        return res;
    }

    private String[][] getFileData(String path) {
        String[] data = path.split(" ");
        String dir = data[0];
        int n = data.length;
        String[][] res = new String[n - 1][2];
        for (int i = 1; i < data.length; i++) {
            String fileName = data[i].substring(0, data[i].indexOf("("));
            res[i - 1][0] = data[i].substring(data[i].indexOf("(") + 1, data[i].indexOf(")"));
            res[i - 1][1] = dir + "/" + fileName;
        }
        return res;
    }
}