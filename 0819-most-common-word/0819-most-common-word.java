import java.util.Map;
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
         HashSet<String> bannedSet = new HashSet<>();
        for (String b : banned) {
            bannedSet.add(b);
        }
        HashMap<String, Integer> wordCountMap = new HashMap<>();
      
        String[] words = paragraph.toLowerCase()
                                  .replaceAll("[^a-zA-Z0-9 ]", " ")
                                  .split("\\s+");
        for(int i=0;i<words.length;i++)
        {   String word=words[i];
            if (word.isEmpty() || bannedSet.contains(word)) {
                continue;
            }
            if (wordCountMap.containsKey(word))
            {
                int currentCount = wordCountMap.get(word);
                wordCountMap.put(word, currentCount + 1);
            }
            else{
                wordCountMap.put(word, 1);
            }
        }

         String mostCommon = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        return mostCommon;     }
}