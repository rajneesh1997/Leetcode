class Solution {
    public String restoreString(String s, int[] indices) {
        String[] ans = new String[indices.length];
        for(int i = 0; i < indices.length; i++){
            ans[indices[i]] = "" + s.charAt(i); 
        }
        String aux = "";
        for(String str : ans)
            aux += str;
        return aux;
    }
}