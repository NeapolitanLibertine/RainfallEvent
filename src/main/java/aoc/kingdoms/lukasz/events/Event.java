//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events;

import aoc.kingdoms.lukasz.events.triggers.EventTrigger;
import aoc.kingdoms.lukasz.jakowski.CFG;
import java.util.ArrayList;
import java.util.List;

public class Event {
    //执行时的省份
    public int execPosition = -1;
    public boolean no_text = false;
    public boolean important = false;
    public boolean no_background = false;
    public boolean super_event = false;
    public String musicName = null;
    public String id;
    public String title = "";
    public String desc = "";
    public String mission_desc = "";
    public String image = null;
    public boolean only_once = true;
    public int mission_image = 0;
    public boolean show_in_missions = false;
    public boolean popUp = false;
    public boolean run_in_background = false;
    public boolean possible_to_run = true;
    public int runCivsID = 0;
    public EventType eventType = EventType.NORMAL_EVENT;
    public int layoutID = -1;//-1 undefined layout,use event type to determine layout.
    public List<EventOption> options = new ArrayList();
    public List<EventTrigger> triggersAnd = new ArrayList();
    public List<EventTrigger> triggersAndNot = new ArrayList();
    public List<EventTrigger> triggersOr = new ArrayList();
    public List<EventTrigger> triggersOrNot = new ArrayList();

    public Event() {
    }

    public void addTrigger(EventTrigger trigger, int typeID) {
        switch (typeID) {
            case 0:
                this.triggersAnd.add(trigger);
                break;
            case 1:
                this.triggersAndNot.add(trigger);
                break;
            case 2:
                this.triggersOr.add(trigger);
                break;
            case 3:
                this.triggersOrNot.add(trigger);
        }

    }

    public final boolean runTriggers(int iCivID) {
        int iProvinceID = 0;

        int i;
        Exception ex;
        for(i = this.triggersOr.size() - 1; i >= 0; --i) {
            try {
                if (this.triggersOr.get(i).runTriggers(iCivID, iProvinceID)) {
                    return true;
                }
            } catch (Exception var8) {
                ex = var8;
                CFG.exceptionStack(ex);
            }
        }

        for(i = this.triggersOrNot.size() - 1; i >= 0; --i) {
            try {
                if (!this.triggersOrNot.get(i).runTriggers(iCivID, iProvinceID)) {
                    return true;
                }
            } catch (Exception var7) {
                ex = var7;
                CFG.exceptionStack(ex);
            }
        }

        for(i = this.triggersAnd.size() - 1; i >= 0; --i) {
            try {
                if (!this.triggersAnd.get(i).runTriggers(iCivID, iProvinceID)) {
                    return false;
                }
            } catch (Exception var6) {
                ex = var6;
                CFG.exceptionStack(ex);
            }
        }

        for(i = this.triggersAndNot.size() - 1; i >= 0; --i) {
            try {
                if (this.triggersAndNot.get(i).runTriggers(iCivID, iProvinceID)) {
                    return false;
                }
            } catch (Exception var5) {
                ex = var5;
                CFG.exceptionStack(ex);
            }
        }

        return !this.triggersAnd.isEmpty() || !this.triggersAndNot.isEmpty();
    }

    public boolean addEvent() {
        return this.triggersAnd.size() + this.triggersOr.size() + this.triggersOrNot.size() + this.triggersAndNot.size() > 0 && this.options.size() > 0;
    }
}
