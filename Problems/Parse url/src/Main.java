import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        String source = url.substring(url.indexOf("?") + 1);
        String[] arrStr = source.split("&");
        Map<String, String> map = new LinkedHashMap<>();
        for (String s : arrStr) {
            String[] temp = s.split("=", -1);
            if (temp[1].equals("")) {
                map.put(temp[0], "not found");
            } else {
                map.put(temp[0], temp[1]);
            }
        }
        if (map.containsKey("pass")) {
            map.put("password", map.get("pass"));
        }
        for (Map.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
}
