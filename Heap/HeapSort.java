class HeapSort
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n) // bottom -> up
    {
        for(int i = (n / 2) - 1; i >= 0; i --) {
            heapify(arr, n, i);
        }
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i) // up -> bottom
    {
        int largest = i;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        
        if(left < n && arr[left] > arr[largest]) largest = left;
        if(right < n && arr[right] > arr[largest]) largest = right;
        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        buildHeap(arr, n);
        
        deleteHeap(arr, n);
    }
    
    public void deleteHeap(int arr[], int n) {
        while(-- n >= 0) {
            int temp = arr[0];
            arr[0] = arr[n];
            arr[n] = temp;
            heapify(arr, n, 0);   
        }
        // for(int i = n - 1; i >= 0; i --) {
        //     int temp = arr[0];
        //     arr[0] = arr[i];
        //     arr[i] = temp;
        //     heapify(arr, -- n, 0);   
        // }
    }
 }
