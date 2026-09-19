class Solution {
    public boolean checkOverlap(int r, int xc, int yc, int x1, int y1, int x2, int y2) {
        int x;
        int y;
        if(xc<x1){
           x=x1;
        }else if(x2<xc){
            x=x2;
        }else{
            x=xc;
        }
        if(yc<y1){
           y=y1;
        }else if(y2<yc){
            y=y2;
        }else{
            y=yc;
        }
        
        int d=(xc-x)*(xc-x)+(yc-y)*(yc-y);
        return  d<=r*r;
    }
}