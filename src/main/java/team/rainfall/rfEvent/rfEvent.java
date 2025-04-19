package team.rainfall.rfEvent;

import aoc.kingdoms.lukasz.events.Event;
import aoc.kingdoms.lukasz.events.EventsManager;
import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.FileManager;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.Missions.Mission;
import aoc.kingdoms.lukasz.jakowski.Missions.MissionTree;
import aoc.kingdoms.lukasz.map.civilization.Civilization;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import team.rainfall.finality.FinalityLogger;

import java.util.ArrayList;

public class rfEvent {
    public static final String CODENAME = "IsolationForest";
    public static void loadMissionForCiv(int iCivID) {
        Civilization civilization = Game.getCiv(iCivID);
        civilization.lMissions.clear();
        civilization.iMissionsSize = 0;
        FileHandle fileList;
        if (FileManager.loadFile("map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + EventsManager.loadScenarioEventsTag + "/" + "missions/" + Game.getCiv(iCivID).getCivTag() + ".json").exists()) {
            fileList = FileManager.loadFile("map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + EventsManager.loadScenarioEventsTag + "/" + "missions/" + Game.getCiv(iCivID).getCivTag() + ".json");
        } else {
            fileList = FileManager.loadFile("map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + EventsManager.loadScenarioEventsTag + "/" + "missions/" + Game.getCiv(iCivID).realTag + ".json");
        }

        String fileContent = fileList.readString();
        Json json = new Json();
        json.setElementType(MissionTree.ConfigMissionsData.class, "Mission", Mission.class);
        MissionTree.ConfigMissionsData data = json.fromJson(MissionTree.ConfigMissionsData.class, fileContent);

        for (Object e : data.Mission) {
            try {
                Mission mission = (Mission) e;
                mission.Name = Game.lang.get(mission.Name);
                FinalityLogger.debug("mission1 "+mission.Name);
                FileHandle tempFileEvent;
                if (FileManager.loadFile("map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + EventsManager.loadScenarioEventsTag + "/" + "missions/" + "missionsEvents/" + mission.MissionEvent).exists()) {
                    tempFileEvent = FileManager.loadFile("map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + EventsManager.loadScenarioEventsTag + "/" + "missions/" + "missionsEvents/" + mission.MissionEvent);
                } else {
                    tempFileEvent = FileManager.loadFile("game/missions/missionsEvents/" + mission.MissionEvent);
                }

                mission.event = EventsManager.loadEvent(999, tempFileEvent.readString().split("\\r?\\n"));
                Game.getCiv(iCivID).lMissions.add(mission);
                Game.getCiv(iCivID).iMissionsSize++;
            } catch (Exception var10) {
                CFG.exceptionStack(var10);
            }
        }
    }

    public static void format(Event event,int civID){
        Civilization civilization = Game.getCiv(civID);
        ArrayList<Counter> counters = new ArrayList<>();
        for (String s : civilization.eventsDataVariables.v) {
            FinalityLogger.debug("Format dbg0 "+s);
            if(s.startsWith("$$" + rfEvent.CODENAME + "_")){
                FinalityLogger.debug("Format dbg1 "+s);
                counters.add(new Counter(s));
            }
        }
        //先本地化一次避免某些奇怪的问题
        FinalityLogger.debug("Format dbg desc "+event.desc+";id "+event.id);
        event.desc = Game.lang.get(event.desc);
        for (Counter counter : counters) {
            FinalityLogger.debug("Format dbg2 "+counter.name);
            event.desc = event.desc.replace("$"+counter.name,String.valueOf(counter.value));
            FinalityLogger.debug("Format dbg3 "+event.desc);
        }
    }
}
