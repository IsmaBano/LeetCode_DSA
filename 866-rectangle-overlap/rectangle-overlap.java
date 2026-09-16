class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1=rec1[0];
        int y1=rec1[1];
        int x2=rec1[2];
        int y2=rec1[3];
        int xx1=rec2[0];
        int yy1=rec2[1];
        int xx2=rec2[2];
        int yy2=rec2[3];
         return x1 < xx2 && xx1 < x2 &&
               y1 < yy2 && yy1 < y2;
    }
}