package tenpin.frame;

public class FrameFactory {
    public Frame createFrame(Integer newFrameNumber) {
        if(newFrameNumber ==10){
            return new TenthFrame();
        }
        else if(newFrameNumber<10 && newFrameNumber>0){
            return new Frame(newFrameNumber);
        }
        else {
            throw new FrameFactoryException("New frame number out of bounds - newFrameNumber:"+newFrameNumber);
        }
    }
}
