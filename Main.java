import java.util.*;
import java.util.regex.*;

class Main {

    public static List<String> sortByValue(HashMap<String, Integer> hm) {
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(hm.entrySet());

        //Sort the hashtags based on freq , if the frequencies are equal prefer key
        list.sort((o1, o2) -> (o1.getValue().equals(o2.getValue())) ? (o1.getKey()).compareTo(o2.getKey()) : (o2.getValue()).compareTo(o1.getValue()));

        List<String> temp = new ArrayList<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.add(aa.getKey());
        }
        return temp;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String noOfTweets = s.nextLine(); //get no of tweets
        int n = Integer.parseInt(noOfTweets);
        HashMap<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String tweet = s.nextLine();
            Pattern pt = Pattern.compile("#(\\w+)");
            Matcher mat = pt.matcher(tweet); //parse hashtags
            while (mat.find()) {
                String hashtag = mat.group(1);
                if (mp.containsKey(hashtag)) {
                    mp.put(hashtag, mp.get(hashtag) + 1); //increase hastag frequency
                } else {
                    mp.put(hashtag, 1); //insert hashtag
                }
            }
        }

        List<String>trending_tweets = sortByValue(mp); //sort hashtags by their frequencies
        int count = 0;
        for (String hashtag : trending_tweets) {
            System.out.println("#" + hashtag ); //Print the hashtag
            count++;
            if (count >= 10)
                break; //Break after printing the top 10 trending tweets.
        }
    }
}
