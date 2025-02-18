// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class IterativeQuickSort {
    void swap(int arr[], int i, int j) 
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    {
        int pivot=arr[h];
        int i=l-1;
        for(int j=l; j<h; j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, h);
        return i+1;

    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    {
        //Try using Stack Data Structure to remove recursion.
        Stack stack=new Stack();

        // push initial values of l and h to stack
        stack.push(l);
        stack.push(h);

        // Keep popping from stack while is not empty
        while (!stack.isEmpty()) {
            // Pop h and l
            h = (int) stack.pop();
            l = (int) stack.pop();

            // Set pivot element at its correct position
            // in sorted array
            int loc = partition(arr, l, h);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (loc - 1 > l) {
                stack.push(l);
                stack.push(loc - 1);
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (loc + 1 < h) {
                stack.push(loc + 1);
                stack.push(h);
            }
        }
    }
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 