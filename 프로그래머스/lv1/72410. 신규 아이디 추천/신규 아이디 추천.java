class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();
        // 2단계
        new_id = new_id.replaceAll("[^a-z\\d\\-_.]", "");
        // 3단계
        new_id = new_id.replaceAll("\\.{2,}", ".");
        // 4단계
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        // 5단계
        if(new_id.length() == 0) new_id += "a";
        // 6단계
        else if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }
        // 7단계
        if(new_id.length() <= 2){
            char last = new_id.charAt(new_id.length()-1);
            for(int i=new_id.length(); i<3; i++) {
                new_id += last;
            }
        }

        
        
        return new_id;
    }
}