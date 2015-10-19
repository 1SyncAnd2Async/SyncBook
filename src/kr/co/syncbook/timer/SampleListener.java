package kr.co.syncbook.timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import kr.co.syncbook.vo.MemberClassVO;
import kr.co.syncbook.vo.MemberVO;
import kr.co.syncbook.web.GCMController;
import kr.co.syncbook.web.MemberController;

public class SampleListener implements ServletContextListener {

    private MyThread myThread = null;
 
    /**
     * 앱 시작시 불리는 함수
     */
    public void contextInitialized(ServletContextEvent sce) {
        if ((myThread == null) || (!myThread.isAlive())) {
            myThread = new MyThread(new MyTask());
            myThread.start();
        }
    }
    /**
     * 앱 종료시 불리는 함수 
     */
    public void contextDestroyed(ServletContextEvent sce){
        if (myThread != null && myThread.isAlive()) {
            myThread.quit();
        }
    }
    
    
    /**
     * 실제 작업하는 클래스
     */ 
    public static class MyTask extends TimerTask {

        @Override
        public void run() {
        	HttpURLConnection connection = null;
            
            try {
//                ProcessBuilder builder = new ProcessBuilder("c:\\bin\\backup.bat");
//                Process p = builder.start();
//                InputStream in = p.getInputStream();
//                while (in.read() != -1) {
//                    Thread.sleep(10);
//                }
//                p.waitFor();
            	
            	URL url = new URL("http://localhost:8081/BitProject/GCMSend");
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Accept-Charset", "UTF-8");
                connection.connect();
                
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(), "UTF-8"));
                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null)
                    {
                        builder.append(line);
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 앱이 실행되는 동안 작업을 기다리는 스레드
     */
    public static class MyThread extends Thread {
        
        private boolean done = false;
        private Timer timer;
        private TimerTask task;
        
        public MyThread (TimerTask task) {
            this.task = task;
        }
        
        public void quit() {
            this.done = true;
            this.interrupt();
        }
        
        public boolean finishing() {
            return (done || Thread.interrupted());
        }

        @Override
        public void run() {
            super.run();
            
            timer = new Timer();
            
            Calendar now = Calendar.getInstance();
            timer.scheduleAtFixedRate(task, now.getTime(), 1000 * 60);
            
            while (!finishing()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    break;
                }
            }
            
            timer.cancel();
        }
    }
}
