public class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Task " + i + " isn't done");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}


@FunctionalInterface
interface OnTaskDoneListener {
    void onDone(String result);
}


@FunctionalInterface
interface OnTaskErrorListener {
    void onError(String result);
}