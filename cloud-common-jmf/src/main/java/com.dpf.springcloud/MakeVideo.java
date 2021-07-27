package com.dpf.springcloud;

import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.OpenCVFrameConverter;

public class MakeVideo {

    static Random random = new Random();
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String []args)
    {
//        Scanner s=new Scanner(System.in);
//        System.out.println("Enter the directory path of images (for eg c:\\test)");
//        String imgPath=s.nextLine();
//        System.out.println("Enter the directory with video file name where resulting video will be saved (for eg c:\\test\\abc.mp4)");
//        String vidPath=s.nextLine();
        String imgPath = "/Users/david.dong/tmp/image/01/";
        String vidPath = "/Users/david.dong/tmp/video/01.mp4";
        ArrayList<String> links = new ArrayList<>();
        File f=new File(imgPath);
        File[] f2=f.listFiles();
        for(File f3:f2)
        {
            links.add(f3.getAbsolutePath());
        }
        links.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int n1 = Integer.parseInt(o1.substring(o1.lastIndexOf('_') + 1, o1.lastIndexOf('.')));
                int n2 = Integer.parseInt(o2.substring(o2.lastIndexOf('_') + 1, o2.lastIndexOf('.')));
                return n1 > n2 ? 1 : -1;
            }
        });
        convertJPGtoMovie(links, vidPath);
        System.out.println("Video has been created at "+vidPath);
    }
    public static void convertJPGtoMovie(ArrayList<String> links, String vidPath)
    {
        OpenCVFrameConverter.ToIplImage grabberConverter = new OpenCVFrameConverter.ToIplImage();
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(vidPath,721,360);
        try {
            recorder.setFrameRate(1);
            recorder.setVideoCodec(avcodec.AV_CODEC_ID_MPEG4);
            recorder.setVideoBitrate(9000);
            recorder.setFormat("mp4");
            recorder.setVideoQuality(0); // maximum quality
            recorder.start();
            long timestamp = 0;
            for (int i=0;i<links.size();i++)
            {
                timestamp += 250000;
                recorder.record(grabberConverter.convert(cvLoadImage(links.get(i))));
            }
            recorder.stop();
        }
        catch (org.bytedeco.javacv.FrameRecorder.Exception e){
            e.printStackTrace();
        }
    }
}