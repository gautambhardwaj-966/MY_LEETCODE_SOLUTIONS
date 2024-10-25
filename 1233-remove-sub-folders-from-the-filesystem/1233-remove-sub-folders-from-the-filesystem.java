class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folders lexicographically
        Arrays.sort(folder);

        List<String> result = new ArrayList<>();
        String prevFolder = null; // Initialize as null to avoid empty string issues

        for (String currentFolder : folder) {
            // If prevFolder is null (first iteration) or currentFolder does not start with prevFolder + "/"
            if (prevFolder == null || !currentFolder.startsWith(prevFolder + "/")) {
                result.add(currentFolder); // Add the folder to the result list
                prevFolder = currentFolder; // Update prevFolder to the current folder
            }
        }

        return result;
    }
}