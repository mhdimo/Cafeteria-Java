package observers;

import models.Cup;

public interface CupObserver {

    void onCupFull(Cup cup);

    void onCupOverflow(Cup cup);
    
}
