/** You are given an integer array height of length n. 
There are n vertical lines drawn such that the two endpoints of the ith 
line are (i, 0) and (i, height[i]). 
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store

height = [1,8,6,2,5,4,8,3,7]

          0,1,2,3,4,5,6,7,8,9
maximum amount of maxmimum number = 8 , x- axis is the container index and y axis is the height of container
move the pointer which is low, we want to reach the maximum frm both the sides
Uses two pointer approach
**/


private void containerWithMostWater (height[]) {

    int left=0
    int right= height.length-1;
    int area =0;
    while (right > left) {
        width = right - left;
        area = Math.min(width * Math.min(height[left], height[right]));
        //we need minmum height because of levelling
        //we need width to get max width at each point
        if(height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
}