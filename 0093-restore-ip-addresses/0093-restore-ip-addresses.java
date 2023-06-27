/**
 * 93. Restore IP Addresses
 * Backtracking
 * Time complexity: O(1)
 * Space comlexity: O(1)
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        if (s.length() < 4) {
            return addresses;
        }
        StringBuilder tempAddress = new StringBuilder();
        doRestore(1, addresses, tempAddress, s);
        return addresses;
    }

    private void doRestore(int k, List<String> addresses, StringBuilder tempAddress, String s) {
        // k means the number of integers already added
        if (k == 5 || s.length() == 0) {
            if (k == 5 && s.length() == 0) {
                addresses.add(tempAddress.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            // check if part starts with '0', if so, stop this DFS
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                // check if part is the first integer, if not, add '.'
                if (tempAddress.length() != 0) {
                    part = '.' + part;
                }
                tempAddress.append(part);
                doRestore(k + 1, addresses, tempAddress, s.substring(i + 1));
                // StringBuilder.delete(index, index + count)
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
            }
        }
    }
}