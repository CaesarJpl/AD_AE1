public class Part3 {
    public static String[] topKVideos(int[] views, int k, String[]  videoNames ){
        String[] topVideos = new String[k];//the list of interested videos with size k
        int[] counts = new int[k];

        for (int i = 0; i < k; i++){
            counts[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < counts.length; i++){
            int counter = views[i];
            String name = videoNames[i];
            int x = k-1;
            while (x >=0 && counter > counts[x]){
                if (x < k-1){
                    counts[x+1] = counts[x];
                    topVideos[x+1] = topVideos[x];
                }
                x-=1;
            }
            if(x<k-1){
                counts[x+1] = counter;
                topVideos[x+1] = name;
            }
        }
        return topVideos;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] viewCounts = {3548, 5600, 500, 880, 8600};
        String[] videoNames = {"video1", "video2", "video3", "video4", "video5"};
        String[] topVideos = topKVideos(viewCounts, k, videoNames);
        System.out.println("Top" + k+ "videos: ");
        for (String video : topVideos) {
            System.out.println(video);
        }
    }

}
