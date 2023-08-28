public class TaskList {
    private Task[] taskList;
    private int taskCount;

    public TaskList() {
        this.taskList = new Task[100];
        this.taskCount = 0;
    }

    public void addTask(String taskName) {
        Task newTask = new Task(taskName);
        taskList[taskCount] = newTask;
        taskCount++;
    }

    public String[] getTasks() {
        String[] tasks = new String[taskCount];
        for (int i = 0; i < taskCount; i++) {
            tasks[i] = taskList[i].toString();
        }
        return tasks;
    }

    public void markTaskAsDone(int taskNumber) {
        taskList[taskNumber - 1].markAsDone();
    }   

    public void unmarkTaskAsDone(int taskNumber) {
        taskList[taskNumber - 1].unmarkAsDone();
    }

    public void deleteTask(int taskNumber) {
        taskList[taskNumber - 1] = null;
        for (int i = taskNumber - 1; i < taskCount - 1; i++) {
            taskList[i] = taskList[i + 1];
        }
        taskCount--;
    }

    public String[] findTasks(String keyword) {
        String[] tasks = new String[taskCount];
        int taskIndex = 0;
        for (int i = 0; i < taskCount; i++) {
            if (taskList[i].getTaskName().contains(keyword)) {
                tasks[taskIndex] = taskList[i].toString();
                taskIndex++;
            }
        }
        return tasks;
    }

}