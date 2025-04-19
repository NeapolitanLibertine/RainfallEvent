//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.events;

import aoc.kingdoms.lukasz.events.outcome.*;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusAdministrationBuildingsCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusAdvisorCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusAdvisorMaxLevel;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusAggressiveExpansion;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusAllCharactersLifeExpectancy;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusArmyMaintenance;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusArmyMoraleRecovery;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusArmyMovementSpeed;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusBattleWidth;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusBuildingsMaintenanceCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusConstructionCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusConstructionTime;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusCoreCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusCorruption;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusDevelopInfrastructureCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusDiplomacyPoints;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusDiscipline;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusDiseaseDeathRate;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusEconomyBuildingsCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusGeneralAttack;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusGeneralCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusGeneralDefense;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusGrowthRate;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusImproveRelationsModifier;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusIncomeEconomy;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusIncomeFromVassals;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusIncomeProduction;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusIncomeTaxation;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusIncreaseGrowthRateCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusIncreaseManpowerCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusIncreaseTaxEfficiencyCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusInflation;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusInvestInEconomyCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusLoanInterest;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusLoansLimit;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusMaintenanceCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusManpowerRecoveryFromADisbandedArmy;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusManpowerRecoverySpeed;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusMaxManpower;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusMaxManpowerPercentage;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusMaxMorale;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusMaximumAmountOfGold;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusMilitaryBuildingsCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusMonthlyIncome;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusMonthlyLegacy;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusMonthlyLegacyPerc;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusProductionEfficiency;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusProvinceMaintenance;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusRecruitArmyCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusRecruitArmyFirstLineCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusRecruitArmySecondLineCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusRecruitmentTime;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusRegimentsLimit;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusReinforcementSpeed;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusReligionCost;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusResearch;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusResearchPoints;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusRevolutionaryRisk;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusSiegeEffectiveness;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusTaxEfficiency;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusUnitsAttack;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusUnitsDefense;
import aoc.kingdoms.lukasz.events.outcome.civilizationBonus.EventOutcome_BonusWarScoreCost;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Devastation;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Devastation_All;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Devastation_Capital;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Devastation_ID;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Economy;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Economy_All;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Economy_Capital;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Economy_ID;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_GrowthRate;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_GrowthRate_All;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_GrowthRate_Capital;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_GrowthRate_ID;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_ID_CoreAdd;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_ID_CoreRemove;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Infrastructure;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Infrastructure_All;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Infrastructure_Capital;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Infrastructure_ID;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Manpower;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Manpower_All;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Manpower_Capital;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Manpower_ID;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Population;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Population_All;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Population_Capital;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Religion;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Religion_All;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Religion_Capital;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Religion_ID;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_TaxEfficiency;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_TaxEfficiency_All;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_TaxEfficiency_Capital;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_TaxEfficiency_ID;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Unrest;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Unrest_All;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Unrest_Capital;
import aoc.kingdoms.lukasz.events.outcome.province.EventOutcome_Province_Unrest_ID;
import aoc.kingdoms.lukasz.events.triggers.*;
import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.FileManager;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.GameValues;
import aoc.kingdoms.lukasz.jakowski.Game_Calendar;
import aoc.kingdoms.lukasz.jakowski.SoundsManager;
import aoc.kingdoms.lukasz.jakowski.Steam.SteamManager;
import aoc.kingdoms.lukasz.map.ResourcesManager;
import aoc.kingdoms.lukasz.map.civilization.CivilizationEventsData_Variables;
import aoc.kingdoms.lukasz.textures.Image;
import aoc.kingdoms.lukasz.textures.ImageManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.codedisaster.steamworks.SteamUGC;
import team.rainfall.rfEvent.rfEvent;

import java.util.ArrayList;
import java.util.List;

public class EventsManager {
    public static Image eventIMG = null;
    public static String loadedEventIMG = "";
    public static List<Event> events = new ArrayList();
    public static int iEventsSize = 0;
    public static List<Event> eventsSiege = new ArrayList();
    public static int iEventsSiegeSize = 0;
    public static List<Event> eventsGlobal = new ArrayList();
    public static int iEventsGlobalSize = 0;
    public static List<Event> eventsScenario = new ArrayList();
    public static int iEventsScenarioSize = 0;
    public static List<Event> eventsSiegeScenario = new ArrayList();
    public static int iEventsSiegeScenarioSize = 0;
    public static List<Event> eventsGlobalScenario = new ArrayList();
    public static int iEventsGlobalScenarioSize = 0;
    public static CivilizationEventsData_Variables eventsGlobal_Variables = new CivilizationEventsData_Variables();
    public static List<Image> missionImages = new ArrayList();
    public static List<String> runEvent = new ArrayList();
    public static List<Event_ExactDate> exactDate_Events = new ArrayList();
    public static List<Event_ExactDate> exactDate_EventsScenario = new ArrayList();
    public static int runEventGlobalID = 0;
    public static int runEventGlobalID_Scenario = 0;
    public static String loadScenarioEventsTag = "";

    public EventsManager() {
    }

    public static Event getActiveEvent(int id, int eventType) {
        switch (eventType) {
            case 1:
                return eventsSiege.get(id);
            case 2:
                return eventsGlobal.get(id);
            case 3:
                return eventsScenario.get(id);
            case 4:
                return eventsSiegeScenario.get(id);
            case 5:
                return eventsGlobalScenario.get(id);
            case 0:
            default:
                return events.get(id);
        }
    }

    public static final void runEvents(int turnID) {
        int i;
        if (!runEvent.isEmpty()) {
            for(i = runEvent.size() - 1; i >= 0; --i) {
                runEvent(i);
            }
        }

        runEvents_ExactDay();

        try {
            int j;
            int score;
            int takeID;
            int a;
            int currentScore;
            for(i = turnID % GameValues.gameUpdate.GAME_UPDATE_EVENTS_EVENTS; i < iEventsSize; i += GameValues.gameUpdate.GAME_UPDATE_EVENTS_EVENTS) {
                for(j = events.get(i).runCivsID % GameValues.gameUpdate.GAME_UPDATE_EVENTS_CIVS; j < Game.getCivsSize(); j += GameValues.gameUpdate.GAME_UPDATE_EVENTS_CIVS) {
                    if (Game.getCiv(j).getNumOfProvinces() > 0 && (!events.get(i).only_once || !Game.getCiv(j).eventsDataVariables.hasVariable(events.get(i).id)) && events.get(i).possible_to_run && events.get(i).runTriggers(j)) {
                        updateRandomProvinceID(j);
                        if (j == Game.player.iCivID) {
                            Game.player.addActiveEvent(0, i, 0);
                            rfEvent.format(EventsManager.events.get(i),j);
                            Game.addSimpleTask(new Game.SimpleTask(events.get(i).id + "0", i) {
                                public void update() {
                                    Game.menuManager.rebuildInGame_Right();
                                    Game.soundsManager.playSound(SoundsManager.EVENT_INFO);
                                    if (EventsManager.events.get(this.id).popUp && !Game.menuManager.getVisibleInGame_Event()) {
                                        Game.menuManager.rebuildInGame_Event(EventsManager.events.get(this.id), 0, this.id);
                                        Game.soundsManager.playSound(SoundsManager.EVENT);
                                    }

                                }
                            });
                        } else if (!events.get(i).options.isEmpty()) {
                            score = 0;

                            for(takeID = 0; takeID < events.get(i).options.size(); ++takeID) {
                                score = (int)((float)score + events.get(i).options.get(takeID).ai);
                            }

                            takeID = 0;
                            if (score > 0) {
                                score = Game.oR.nextInt(score);
                                a = 0;

                                for(currentScore = 0; a < events.get(i).options.size(); ++a) {
                                    if(score <= events.get(i).options.get(a).ai + currentScore){
                                        takeID = a;
                                        break;
                                    }
                                    currentScore = currentScore + (int) events.get(i).options.get(a).ai;
                                }
                            }

                            Game.getCiv(j).eventsDataVariables.addVariable(events.get(i).id);
                            events.get(i).options.get(takeID).executeOutcome(j);
                        }
                    }
                }

                ++events.get(i).runCivsID;
                if (events.get(i).runCivsID >= GameValues.gameUpdate.GAME_UPDATE_EVENTS_CIVS) {
                    events.get(i).runCivsID = 0;
                }
            }

            if (Game.SCENARIO_EVENTS) {
                for(i = turnID % GameValues.gameUpdate.GAME_UPDATE_EVENTS_EVENTS; i < iEventsScenarioSize; i += GameValues.gameUpdate.GAME_UPDATE_EVENTS_EVENTS) {
                    for(j = eventsScenario.get(i).runCivsID % GameValues.gameUpdate.GAME_UPDATE_EVENTS_CIVS; j < Game.getCivsSize(); j += GameValues.gameUpdate.GAME_UPDATE_EVENTS_CIVS) {

                        if (Game.getCiv(j).getNumOfProvinces() > 0 && (!eventsScenario.get(i).only_once || !Game.getCiv(j).eventsDataVariables.hasVariable(eventsScenario.get(i).id)) && eventsScenario.get(i).possible_to_run && eventsScenario.get(i).runTriggers(j)) {
                            updateRandomProvinceID(j);
                            if (j == Game.player.iCivID) {
                                Game.player.addActiveEvent(3, i, 0);
                                rfEvent.format(EventsManager.eventsScenario.get(i),j);
                                Game.addSimpleTask(new Game.SimpleTask(eventsScenario.get(i).id + "3", i) {
                                    public void update() {
                                        Game.menuManager.rebuildInGame_Right();
                                        Game.soundsManager.playSound(SoundsManager.EVENT_INFO);
                                        if (EventsManager.eventsScenario.get(this.id).popUp && !Game.menuManager.getVisibleInGame_Event()) {
                                            Game.menuManager.rebuildInGame_Event(EventsManager.eventsScenario.get(this.id), 3, this.id);
                                            Game.soundsManager.playSound(SoundsManager.EVENT);
                                        }

                                    }
                                });
                            } else if (!eventsScenario.get(i).options.isEmpty()) {
                                score = 0;

                                for(takeID = 0; takeID < eventsScenario.get(i).options.size(); ++takeID) {
                                    score = (int)((float)score + eventsScenario.get(i).options.get(takeID).ai);
                                }

                                takeID = 0;
                                if (score > 0) {
                                    score = Game.oR.nextInt(score);
                                    a = 0;

                                    for(currentScore = 0; a < eventsScenario.get(i).options.size(); ++a) {
                                        if(score <= eventsScenario.get(i).options.get(a).ai + currentScore){
                                            takeID = a;
                                            break;
                                        }
                                        currentScore = currentScore + (int) eventsScenario.get(i).options.get(a).ai;
                                    }
                                }

                                Game.getCiv(j).eventsDataVariables.addVariable(eventsScenario.get(i).id);
                                eventsScenario.get(i).options.get(takeID).executeOutcome(j);
                            }
                        }
                    }

                    ++eventsScenario.get(i).runCivsID;
                    if (eventsScenario.get(i).runCivsID >= GameValues.gameUpdate.GAME_UPDATE_EVENTS_CIVS) {
                        eventsScenario.get(i).runCivsID = 0;
                    }
                }
            }
        } catch (Exception var7) {
            CFG.exceptionStack(var7);
        }

    }

    public static final void runEvent(int runID) {
        try {
            int j;
            int score;
            int takeID;
            int a;
            int currentScore;
            int i;
            if (Game.SCENARIO_EVENTS) {
                for(i = 0; i < iEventsScenarioSize; ++i) {
                    if (eventsScenario.get(i).id.equals(runEvent.get(runID))) {
                        for(j = 1; j < Game.getCivsSize(); ++j) {
                            if (Game.getCiv(j).getNumOfProvinces() > 0 && (!eventsScenario.get(i).only_once || !Game.getCiv(j).eventsDataVariables.hasVariable(eventsScenario.get(i).id)) && eventsScenario.get(i).runTriggers(j)) {
                                updateRandomProvinceID(j);
                                if (j == Game.player.iCivID) {
                                    rfEvent.format(EventsManager.eventsScenario.get(i),j);
                                    Game.player.addActiveEvent(3, i, 0);
                                    Game.addSimpleTask(new Game.SimpleTask(eventsScenario.get(i).id + "3", i) {
                                        public void update() {
                                            Game.menuManager.rebuildInGame_Right();
                                            Game.soundsManager.playSound(SoundsManager.EVENT_INFO);
                                            if (EventsManager.eventsScenario.get(this.id).popUp && !Game.menuManager.getVisibleInGame_Event()) {
                                                Game.menuManager.rebuildInGame_Event(EventsManager.eventsScenario.get(this.id), 3, this.id);
                                                Game.soundsManager.playSound(SoundsManager.EVENT);
                                            }

                                        }
                                    });
                                } else if (!eventsScenario.get(i).options.isEmpty()) {
                                    score = 0;

                                    for(takeID = 0; takeID < eventsScenario.get(i).options.size(); ++takeID) {
                                        score = (int)((float)score + eventsScenario.get(i).options.get(takeID).ai);
                                    }

                                    takeID = 0;
                                    if (score > 0) {
                                        score = Game.oR.nextInt(score);
                                        a = 0;

                                        for(currentScore = 0; a < eventsScenario.get(i).options.size(); ++a) {
                                            if(score <= eventsScenario.get(i).options.get(a).ai + currentScore){
                                                takeID = a;
                                                break;
                                            }
                                            currentScore = currentScore + (int) eventsScenario.get(i).options.get(a).ai;
                                        }
                                    }

                                    Game.getCiv(j).eventsDataVariables.addVariable(eventsScenario.get(i).id);
                                    eventsScenario.get(i).options.get(takeID).executeOutcome(j);
                                }
                            }
                        }

                        runEvent.remove(runID);
                        return;
                    }
                }
            }

            for(i = 0; i < iEventsSize; ++i) {
                if (events.get(i).id.equals(runEvent.get(runID))) {
                    for(j = 1; j < Game.getCivsSize(); ++j) {
                        if (Game.getCiv(j).getNumOfProvinces() > 0 && (!events.get(i).only_once || !Game.getCiv(j).eventsDataVariables.hasVariable(events.get(i).id)) && events.get(i).runTriggers(j)) {
                            updateRandomProvinceID(j);
                            if (j == Game.player.iCivID) {
                                rfEvent.format(EventsManager.events.get(i),j);
                                Game.player.addActiveEvent(0, i, 0);
                                Game.addSimpleTask(new Game.SimpleTask(events.get(i).id + "0", i) {
                                    public void update() {
                                        Game.menuManager.rebuildInGame_Right();
                                        Game.soundsManager.playSound(SoundsManager.EVENT_INFO);
                                        if (EventsManager.events.get(this.id).popUp && !Game.menuManager.getVisibleInGame_Event()) {
                                            Game.menuManager.rebuildInGame_Event(EventsManager.events.get(this.id), 0, this.id);
                                            Game.soundsManager.playSound(SoundsManager.EVENT);
                                        }

                                    }
                                });
                            } else if (!events.get(i).options.isEmpty()) {
                                score = 0;

                                for(takeID = 0; takeID < events.get(i).options.size(); ++takeID) {
                                    score = (int)((float)score + events.get(i).options.get(takeID).ai);
                                }

                                takeID = 0;
                                if (score > 0) {
                                    score = Game.oR.nextInt(score);
                                    a = 0;

                                    for(currentScore = 0; a < events.get(i).options.size(); ++a) {
                                        if(score <= events.get(i).options.get(a).ai + currentScore){
                                            takeID = a;
                                            break;
                                        }
                                        currentScore = currentScore + (int) events.get(i).options.get(a).ai;
                                    }
                                }

                                Game.getCiv(j).eventsDataVariables.addVariable(events.get(i).id);
                                events.get(i).options.get(takeID).executeOutcome(j);
                            }
                        }
                    }

                    runEvent.remove(runID);
                    return;
                }
            }
        } catch (Exception var7) {
            Exception ex = var7;
            CFG.exceptionStack(ex);
        }

    }

    public static final void runEvents_ExactDay() {
        try {
            int j;
            int score;
            int takeID;
            int a;
            int currentScore;
            int z;
            if (!exactDate_Events.isEmpty()) {
                for(z = exactDate_Events.size() - 1; z >= 0; --z) {
                    if (Game_Calendar.currentYear > exactDate_Events.get(z).year || Game_Calendar.currentYear >= exactDate_Events.get(z).year && Game_Calendar.currentMonth > exactDate_Events.get(z).month || Game_Calendar.currentYear >= exactDate_Events.get(z).year && Game_Calendar.currentMonth >= exactDate_Events.get(z).month && Game_Calendar.currentDay >= exactDate_Events.get(z).day) {
                        for(j = 1; j < Game.getCivsSize(); ++j) {
                            if (Game.getCiv(j).getNumOfProvinces() > 0 && (!events.get(exactDate_Events.get(z).eventID).only_once || !Game.getCiv(j).eventsDataVariables.hasVariable(events.get(exactDate_Events.get(z).eventID).id)) && events.get(exactDate_Events.get(z).eventID).runTriggers(j)) {
                                updateRandomProvinceID(j);
                                if (j == Game.player.iCivID) {
                                    rfEvent.format(EventsManager.events.get(exactDate_Events.get(z).eventID),j);
                                    Game.player.addActiveEvent(0, exactDate_Events.get(z).eventID, 0);
                                    Game.addSimpleTask(new Game.SimpleTask(events.get(exactDate_Events.get(z).eventID).id + "0", exactDate_Events.get(z).eventID) {
                                        public void update() {
                                            Game.menuManager.rebuildInGame_Right();
                                            Game.soundsManager.playSound(SoundsManager.EVENT_INFO);
                                            if (EventsManager.events.get(this.id).popUp && !Game.menuManager.getVisibleInGame_Event()) {
                                                Game.menuManager.rebuildInGame_Event(EventsManager.events.get(this.id), 0, this.id);
                                                Game.soundsManager.playSound(SoundsManager.EVENT);
                                            }

                                        }
                                    });
                                } else if (!events.get(exactDate_Events.get(z).eventID).options.isEmpty()) {
                                    score = 0;

                                    for(takeID = 0; takeID < events.get(exactDate_Events.get(z).eventID).options.size(); ++takeID) {
                                        score = (int)((float)score + events.get(exactDate_Events.get(z).eventID).options.get(takeID).ai);
                                    }

                                    takeID = 0;
                                    if (score > 0) {
                                        score = Game.oR.nextInt(score);
                                        a = 0;

                                        Event event = events.get(exactDate_Events.get(z).eventID);
                                        for(currentScore = 0; a < event.options.size(); ++a) {
                                            if(score <= event.options.get(a).ai + currentScore){
                                                takeID = a;
                                                break;
                                            }
                                            currentScore = currentScore + (int) event.options.get(a).ai;
                                        }
                                    }

                                    Game.getCiv(j).eventsDataVariables.addVariable(events.get(exactDate_Events.get(z).eventID).id);
                                    events.get(exactDate_Events.get(z).eventID).options.get(takeID).executeOutcome(j);
                                }
                            }
                        }

                        exactDate_Events.remove(z);
                    }
                }
            }

            if (!exactDate_EventsScenario.isEmpty()) {
                for(z = exactDate_EventsScenario.size() - 1; z >= 0; --z) {
                    if (Game_Calendar.currentYear > exactDate_EventsScenario.get(z).year || Game_Calendar.currentYear >= exactDate_EventsScenario.get(z).year && Game_Calendar.currentMonth > exactDate_EventsScenario.get(z).month || Game_Calendar.currentYear >= exactDate_EventsScenario.get(z).year && Game_Calendar.currentMonth >= exactDate_EventsScenario.get(z).month && Game_Calendar.currentDay >= exactDate_EventsScenario.get(z).day) {
                        for(j = 1; j < Game.getCivsSize(); ++j) {
                            if (Game.getCiv(j).getNumOfProvinces() > 0 && (!eventsScenario.get(exactDate_EventsScenario.get(z).eventID).only_once || !Game.getCiv(j).eventsDataVariables.hasVariable(eventsScenario.get(exactDate_EventsScenario.get(z).eventID).id)) && eventsScenario.get(exactDate_EventsScenario.get(z).eventID).runTriggers(j)) {
                                updateRandomProvinceID(j);
                                if (j == Game.player.iCivID) {
                                    rfEvent.format(EventsManager.eventsScenario.get(exactDate_EventsScenario.get(z).eventID),j);
                                    Game.player.addActiveEvent(3, exactDate_EventsScenario.get(z).eventID, 0);
                                    Game.addSimpleTask(new Game.SimpleTask(eventsScenario.get(exactDate_EventsScenario.get(z).eventID).id + "3", exactDate_EventsScenario.get(z).eventID) {
                                        public void update() {
                                            Game.menuManager.rebuildInGame_Right();
                                            Game.soundsManager.playSound(SoundsManager.EVENT_INFO);
                                            if (EventsManager.eventsScenario.get(this.id).popUp && !Game.menuManager.getVisibleInGame_Event()) {
                                                Game.menuManager.rebuildInGame_Event(EventsManager.eventsScenario.get(this.id), 3, this.id);
                                                Game.soundsManager.playSound(SoundsManager.EVENT);
                                            }

                                        }
                                    });
                                } else if (!eventsScenario.get(exactDate_EventsScenario.get(z).eventID).options.isEmpty()) {
                                    score = 0;

                                    for(takeID = 0; takeID < eventsScenario.get(exactDate_EventsScenario.get(z).eventID).options.size(); ++takeID) {
                                        score = (int)((float)score + eventsScenario.get(exactDate_EventsScenario.get(z).eventID).options.get(takeID).ai);
                                    }

                                    takeID = 0;
                                    if (score > 0) {
                                        score = Game.oR.nextInt(score);
                                        a = 0;
                                        Event event = eventsScenario.get(exactDate_EventsScenario.get(z).eventID);
                                        for(currentScore = 0; a < event.options.size(); ++a) {
                                            if(score <= event.options.get(a).ai + currentScore){
                                                takeID = a;
                                                break;
                                            }
                                            currentScore = currentScore + (int) event.options.get(a).ai;
                                        }
                                    }

                                    Game.getCiv(j).eventsDataVariables.addVariable(eventsScenario.get(exactDate_EventsScenario.get(z).eventID).id);
                                    eventsScenario.get(exactDate_EventsScenario.get(z).eventID).options.get(takeID).executeOutcome(j);
                                }
                            }
                        }

                        exactDate_EventsScenario.remove(z);
                    }
                }
            }
        } catch (Exception var6) {
            Exception ex = var6;
            CFG.exceptionStack(ex);
        }

    }

    public static final void runEvents_Siege(int iCivID, int iProvinceID) {
        try {
            int score;
            int takeID;
            int a;
            int currentScore;
            int i;
            for(i = 0; i < iEventsSiegeSize; ++i) {
                if ((!eventsSiege.get(i).only_once || !Game.getCiv(iCivID).eventsDataVariables.hasVariable(eventsSiege.get(i).id)) && eventsSiege.get(i).runTriggers(iCivID)) {
                    updateRandomProvinceID(iCivID);
                    if (iCivID == Game.player.iCivID) {
                        Game.player.addActiveEvent(1, i, 0);
                        Game.addSimpleTask(new Game.SimpleTask(eventsSiege.get(i).id + "1", i) {
                            public void update() {
                                Game.menuManager.rebuildInGame_Right();
                                if (EventsManager.eventsSiege.get(this.id).popUp && !Game.menuManager.getVisibleInGame_Event()) {
                                    Game.menuManager.rebuildInGame_Event(EventsManager.eventsSiege.get(this.id), 1, this.id);
                                    Game.soundsManager.playSound(SoundsManager.EVENT);
                                }

                            }
                        });
                        break;
                    }

                    if (eventsSiege.get(i).options.size() <= 0) {
                        break;
                    }

                    score = 0;

                    for(takeID = 0; takeID < eventsSiege.get(i).options.size(); ++takeID) {
                        score = (int)((float)score + eventsSiege.get(i).options.get(takeID).ai);
                    }

                    takeID = 0;
                    if (score > 0) {
                        score = Game.oR.nextInt(score);
                        a = 0;
                        Event event = eventsSiege.get(i);
                        for(currentScore = 0; a < event.options.size(); ++a) {
                            if(score <= event.options.get(a).ai + currentScore){
                                takeID = a;
                                break;
                            }
                            currentScore = currentScore + (int) event.options.get(a).ai;
                        }
                    }

                    Game.getCiv(iCivID).eventsDataVariables.addVariable(eventsSiege.get(i).id);
                    eventsSiege.get(i).options.get(takeID).executeOutcome(iCivID);
                    break;
                }
            }

            for(i = 0; i < iEventsSiegeScenarioSize; ++i) {
                if ((!eventsSiegeScenario.get(i).only_once || !Game.getCiv(iCivID).eventsDataVariables.hasVariable(eventsSiegeScenario.get(i).id)) && eventsSiegeScenario.get(i).runTriggers(iCivID)) {
                    updateRandomProvinceID(iCivID);
                    if (iCivID == Game.player.iCivID) {
                        Game.player.addActiveEvent(4, i, 0);
                        Game.addSimpleTask(new Game.SimpleTask(eventsSiegeScenario.get(i).id + "4", i) {
                            public void update() {
                                Game.menuManager.rebuildInGame_Right();
                                if (EventsManager.eventsSiegeScenario.get(this.id).popUp && !Game.menuManager.getVisibleInGame_Event()) {
                                    Game.menuManager.rebuildInGame_Event(EventsManager.eventsSiegeScenario.get(this.id), 4, this.id);
                                    Game.soundsManager.playSound(SoundsManager.EVENT);
                                }

                            }
                        });
                    } else if (!eventsSiegeScenario.get(i).options.isEmpty()) {
                        score = 0;

                        for(takeID = 0; takeID < eventsSiegeScenario.get(i).options.size(); ++takeID) {
                            score = (int)((float)score + eventsSiegeScenario.get(i).options.get(takeID).ai);
                        }

                        takeID = 0;
                        if (score > 0) {
                            score = Game.oR.nextInt(score);
                            a = 0;

                            for(currentScore = 0; a < eventsSiegeScenario.get(i).options.size(); ++a) {
                                if ((float)score <= (float)currentScore + eventsSiegeScenario.get(i).options.get(a).ai) {
                                    takeID = a;
                                    break;
                                }
                            }
                        }

                        Game.getCiv(iCivID).eventsDataVariables.addVariable(eventsSiegeScenario.get(i).id);
                        eventsSiegeScenario.get(i).options.get(takeID).executeOutcome(iCivID);
                    }
                    break;
                }
            }
        } catch (Exception var7) {
            Exception ex = var7;
            CFG.exceptionStack(ex);
        }

    }

    public static final void runEvents_Global(int turnID) {
        Exception ex;
        try {
            boolean updateMenu;
            if (turnID % GameValues.events.RUN_GLOBAL_EVENTS_EVERY_X_TURNS == 0) {
                try {
                    if (runEventGlobalID < iEventsGlobalSize && (!eventsGlobal.get(runEventGlobalID).only_once || !eventsGlobal_Variables.hasVariable(eventsGlobal.get(runEventGlobalID).id)) && eventsGlobal.get(runEventGlobalID).runTriggers(0)) {
                        updateRandomProvinceID(0);
                        eventsGlobal_Variables.addVariable(getActiveEvent(runEventGlobalID, 2).id);
                        updateMenu = !GameValues.events.EVENT_CHANGE_PRICE_SHOW_ONLY_THOSE_THAT_PLAYER_HAS;

                        try {
                            if (!updateMenu) {
                                updateMenu = updateMenu || !eventsGlobal.get(runEventGlobalID).options.isEmpty() && !eventsGlobal.get(runEventGlobalID).options.get(0).outcome.isEmpty() && ResourcesManager.hasResource(Game.player.iCivID, eventsGlobal.get(runEventGlobalID).options.get(0).outcome.get(0).getValue1());
                            }
                        } catch (Exception var5) {
                        }

                        eventsGlobal.get(runEventGlobalID).options.get(0).executeOutcome();
                        if (updateMenu) {
                            Game.player.addActiveEvent(2, runEventGlobalID, -(GameValues.events.EVENT_TIME_TO_RESPOND / 2));
                            Game.addSimpleTask(new Game.SimpleTask(eventsGlobal.get(runEventGlobalID).id + "2", runEventGlobalID) {
                                public void update() {
                                    Game.menuManager.rebuildInGame_Right();
                                    if (EventsManager.eventsGlobal.get(this.id).popUp && !Game.menuManager.getVisibleInGame_Event()) {
                                        Game.menuManager.rebuildInGame_Event(EventsManager.eventsGlobal.get(this.id), 2, this.id);
                                        Game.soundsManager.playSound(SoundsManager.EVENT);
                                    }

                                }
                            });
                        } else if (!eventsGlobal.get(runEventGlobalID).options.isEmpty()) {
                            eventsGlobal.get(runEventGlobalID).options.get(0).executeOutcome(0);
                        }
                    }
                } catch (Exception var6) {
                    ex = var6;
                    CFG.exceptionStack(ex);
                }

                ++runEventGlobalID;
                if (runEventGlobalID >= iEventsGlobalSize) {
                    runEventGlobalID = 0;
                }
            }

            if (turnID % GameValues.events.RUN_GLOBAL_EVENTS_EVERY_X_TURNS == 0) {
                try {
                    if (runEventGlobalID_Scenario < iEventsGlobalScenarioSize && (!eventsGlobalScenario.get(runEventGlobalID_Scenario).only_once || !eventsGlobal_Variables.hasVariable(eventsGlobalScenario.get(runEventGlobalID_Scenario).id)) && eventsGlobalScenario.get(runEventGlobalID_Scenario).runTriggers(0)) {
                        updateRandomProvinceID(0);
                        eventsGlobal_Variables.addVariable(getActiveEvent(runEventGlobalID_Scenario, 5).id);
                        updateMenu = !GameValues.events.EVENT_CHANGE_PRICE_SHOW_ONLY_THOSE_THAT_PLAYER_HAS;

                        try {
                            if (!updateMenu) {
                                updateMenu = updateMenu || !eventsGlobalScenario.get(runEventGlobalID_Scenario).options.isEmpty() && !eventsGlobalScenario.get(runEventGlobalID_Scenario).options.get(0).outcome.isEmpty() && ResourcesManager.hasResource(Game.player.iCivID, eventsGlobalScenario.get(runEventGlobalID_Scenario).options.get(0).outcome.get(0).getValue1());
                            }
                        } catch (Exception var3) {
                        }

                        eventsGlobalScenario.get(runEventGlobalID_Scenario).options.get(0).executeOutcome();
                        if (updateMenu) {
                            Game.player.addActiveEvent(5, runEventGlobalID_Scenario, -(GameValues.events.EVENT_TIME_TO_RESPOND / 2));
                            Game.addSimpleTask(new Game.SimpleTask(eventsGlobalScenario.get(runEventGlobalID_Scenario).id + "5", runEventGlobalID_Scenario) {
                                public void update() {
                                    Game.menuManager.rebuildInGame_Right();
                                    if (EventsManager.eventsGlobalScenario.get(this.id).popUp && !Game.menuManager.getVisibleInGame_Event()) {
                                        Game.menuManager.rebuildInGame_Event(EventsManager.eventsGlobalScenario.get(this.id), 5, this.id);
                                        Game.soundsManager.playSound(SoundsManager.EVENT);
                                    }

                                }
                            });
                        } else if (!eventsGlobalScenario.get(runEventGlobalID_Scenario).options.isEmpty()) {
                            eventsGlobalScenario.get(runEventGlobalID_Scenario).options.get(0).executeOutcome(0);
                        }
                    }
                } catch (Exception var4) {
                    ex = var4;
                    CFG.exceptionStack(ex);
                }

                ++runEventGlobalID_Scenario;
                if (runEventGlobalID_Scenario >= iEventsGlobalScenarioSize) {
                    runEventGlobalID_Scenario = 0;
                }
            }
        } catch (Exception var7) {
            ex = var7;
            CFG.exceptionStack(ex);
        }

    }

    public static final void takeEventDecision(int iCivID, int eventType, int eventID, int optionID) {
        Exception ex;
        try {
            if (eventType == 2) {
                eventsGlobal_Variables.addVariable(getActiveEvent(eventID, eventType).id);
            } else if (eventType == 5) {
                eventsGlobal_Variables.addVariable(getActiveEvent(eventID, eventType).id);
            } else {
                Game.getCiv(iCivID).eventsDataVariables.addVariable(getActiveEvent(eventID, eventType).id);
            }
        } catch (Exception var6) {
            ex = var6;
            CFG.exceptionStack(ex);
        }

        try {
            getActiveEvent(eventID, eventType).options.get(optionID).executeOutcome(iCivID);
        } catch (Exception var5) {
            ex = var5;
            CFG.exceptionStack(ex);
        }

    }

    public static final void updateRandomProvinceID(int iCivID) {
        if (Game.getCiv(iCivID).getNumOfProvinces() > 0) {
            Game.getCiv(iCivID).eventProvinceID = Game.getCiv(iCivID).getProvinceID(Game.oR.nextInt(Game.getCiv(iCivID).getNumOfProvinces()));
        } else if (Game.getCiv(iCivID).getCapitalProvinceID() >= 0 && Game.getProvince(Game.getCiv(iCivID).getCapitalProvinceID()).getCivID() == iCivID) {
            Game.getCiv(iCivID).eventProvinceID = Game.getCiv(iCivID).getCapitalProvinceID();
        } else {
            if (iCivID == 0) {
                for(int i = 0; i < 500; ++i) {
                    Game.getCiv(iCivID).eventProvinceID = Game.oR.nextInt(Game.getProvincesSize());
                    if (!Game.getProvince(Game.getCiv(iCivID).eventProvinceID).getSeaProvince() && Game.getProvince(Game.getCiv(iCivID).eventProvinceID).getWasteland() < 0) {
                        return;
                    }
                }
            }

        }
    }

    public static final void loadEvents() {
        if (CFG.isDesktop()) {
            try {
                boolean generateList = false;
                FileHandle tempFileT = FileManager.loadFile("game/events/generate_list.txt");
                generateList = Boolean.parseBoolean(tempFileT.readString());
                if (generateList) {
                    FileHandle[] files = Gdx.files.local("game/events/common/").list();
                    FileHandle fileWrite = Gdx.files.local("game/events/list_common.txt");
                    fileWrite.writeString("", false);

                    for(int i = 0; i < files.length; ++i) {
                        fileWrite.writeString(files[i].name() + ";", true);
                    }

                    FileHandle[] files2 = Gdx.files.local("game/events/siege/").list();
                    FileHandle fileWrite2 = Gdx.files.local("game/events/list_siege.txt");
                    fileWrite2.writeString("", false);

                    for(int i = 0; i < files2.length; ++i) {
                        fileWrite2.writeString(files2[i].name() + ";", true);
                    }

                    FileHandle[] files3 = Gdx.files.local("game/events/global/").list();
                    FileHandle fileWrite3 = Gdx.files.local("game/events/list_global.txt");
                    fileWrite3.writeString("", false);

                    for(int i = 0; i < files3.length; ++i) {
                        fileWrite3.writeString(files3[i].name() + ";", true);
                    }
                }
            } catch (Exception var9) {
                Exception ex = var9;
                CFG.exceptionStack(ex);
            }
        }

        loadEvents(0);
        loadEvents(1);
        loadEvents(2);
        loadMissionImages();
    }

    public static final void loadEvents_Scenario() {
        loadEvents_Scenario(3);
        loadEvents_Scenario(4);
        loadEvents_Scenario(5);
    }

    public static void clearEventsScenario() {
        eventsScenario.clear();
        eventsSiegeScenario.clear();
        eventsGlobalScenario.clear();
        iEventsScenarioSize = 0;
        iEventsSiegeScenarioSize = 0;
        iEventsGlobalScenarioSize = 0;
        runEvent.clear();
        exactDate_EventsScenario.clear();
        exactDate_Events.clear();
    }

    public static final void loadEvents(int eventsType) {
        String sEventsPath = eventsType == 0 ? "common/" : (eventsType == 1 ? "siege/" : "global/");
        String sEventsPath_List = eventsType == 0 ? "list_common.txt" : (eventsType == 1 ? "list_siege.txt" : "list_global.txt");
        //GdxRuntimeException ex;
        String[] tempSplit;
        int i;
        int iSize;
        Exception ex;
        FileHandle tempFileT;
        FileHandle tempFileEvent;
        if (CFG.isDesktop()) {
            if (FileManager.IS_MAC) {
                try {
                    tempFileT = FileManager.loadFile("game/events/" + sEventsPath_List);
                    tempSplit = tempFileT.readString().split(";");
                    i = 0;

                    for(iSize = tempSplit.length; i < iSize; ++i) {
                        try {
                            if (!tempSplit[i].isEmpty()) {
                                tempFileEvent = FileManager.loadFile("game/events/" + sEventsPath + tempSplit[i]);
                                loadEvent(eventsType, tempFileEvent.readString().split("\\r?\\n"));
                            }
                        } catch (Exception var14) {
                            ex = var14;
                            CFG.exceptionStack(ex);
                        }
                    }
                } catch (GdxRuntimeException var16) {
                    ex = var16;
                    CFG.exceptionStack(ex);
                }
            }

            FileHandle[] files = Gdx.files.internal("game/events/" + sEventsPath).list();
            FileHandle[] var19 = files;
            i = files.length;

            for(iSize = 0; iSize < i; ++iSize) {
                tempFileEvent = var19[iSize];

                try {
                    loadEvent(eventsType, tempFileEvent.readString().split("\\r?\\n"));
                } catch (Exception var13) {
                    CFG.exceptionStack(var13);
                }
            }


            FileHandle[] var21;
            int var23;
            FileHandle file;
            for(i = 0; i < SteamManager.modsFoldersSize; ++i) {
                if (FileManager.IS_MAC) {
                    files = Gdx.files.external(SteamManager.modsFolders.get(i) + "game/" + "events/" + sEventsPath).list();
                } else {
                    files = Gdx.files.internal(SteamManager.modsFolders.get(i) + "game/" + "events/" + sEventsPath).list();
                }

                var21 = files;
                iSize = files.length;

                for(var23 = 0; var23 < iSize; ++var23) {
                    file = var21[var23];

                    try {
                        loadEvent(eventsType, file.readString().split("\\r?\\n"));
                    } catch (Exception var12) {
                        ex = var12;
                        CFG.exceptionStack(ex);
                    }
                }
            }

            for(i = 0; i < SteamManager.itemsInstalledSize; ++i) {
                files = Gdx.files.absolute(SteamManager.itemsInstalled.get(i).getFolder() + "/" + "game/" + "events/" + sEventsPath).list();
                var21 = files;
                iSize = files.length;

                for(var23 = 0; var23 < iSize; ++var23) {
                    file = var21[var23];

                    try {
                        loadEvent(eventsType, file.readString().split("\\r?\\n"));
                    } catch (Exception var11) {
                        ex = var11;
                        CFG.exceptionStack(ex);
                    }
                }
            }
        } else {
            try {
                tempFileT = FileManager.loadFile("game/events/" + sEventsPath_List);
                tempSplit = tempFileT.readString().split(";");
                i = 0;

                for(iSize = tempSplit.length; i < iSize; ++i) {
                    try {
                        if (!tempSplit[i].isEmpty()) {
                            tempFileEvent = FileManager.loadFile("game/events/" + sEventsPath + tempSplit[i]);
                            loadEvent(eventsType, tempFileEvent.readString().split("\\r?\\n"));
                        }
                    } catch (Exception var10) {
                        ex = var10;
                        CFG.exceptionStack(ex);
                    }
                }
            } catch (GdxRuntimeException var15) {
                ex = var15;
                CFG.exceptionStack(ex);
            }
        }

        if (eventsType == 0) {
            iEventsSize = events.size();
        } else if (eventsType == 1) {
            iEventsSiegeSize = eventsSiege.size();
        } else if (eventsType == 2) {
            iEventsGlobalSize = eventsGlobal.size();
            GameValues.events.RUN_GLOBAL_EVENTS_EVERY_X_TURNS = Math.max(10, GameValues.events.RUN_GLOBAL_EVENTS_EVERY_X_TURNS / Math.max(1, iEventsGlobalSize));
        }

        if (eventsType == 3) {
            iEventsScenarioSize = eventsScenario.size();
        } else if (eventsType == 4) {
            iEventsSiegeScenarioSize = eventsSiegeScenario.size();
        } else if (eventsType == 5) {
            iEventsGlobalScenarioSize = eventsGlobalScenario.size();
        }

    }

    public static final void loadEvents_Scenario(int eventsType) {
        String sEventsPath = eventsType == 3 ? "common/" : (eventsType == 4 ? "siege/" : "global/");
        String sEventsPath_List = eventsType == 3 ? "list_common.txt" : (eventsType == 4 ? "list_siege.txt" : "list_global.txt");
        //GdxRuntimeException ex;
        String[] tempSplit;
        int i;
        int iSize;
        Exception ex;
        FileHandle tempFileT;
        FileHandle tempFileEvent;
        if (CFG.isDesktop()) {
            if (FileManager.IS_MAC) {
                try {
                    try {
                        if (FileManager.loadFile("map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + loadScenarioEventsTag + "/" + "events/").exists()) {
                            tempFileT = FileManager.loadFile("map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + loadScenarioEventsTag + "/" + "events/" + sEventsPath_List);
                            tempSplit = tempFileT.readString().split(";");
                            i = 0;

                            for(iSize = tempSplit.length; i < iSize; ++i) {
                                try {
                                    if (!tempSplit[i].isEmpty()) {
                                        tempFileEvent = FileManager.loadFile("map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + loadScenarioEventsTag + "/" + "events/" + sEventsPath + tempSplit[i]);
                                        loadEvent(eventsType, tempFileEvent.readString().split("\\r?\\n"));
                                    }
                                } catch (Exception var14) {
                                    ex = var14;
                                    CFG.exceptionStack(ex);
                                }
                            }
                        }
                    } catch (Exception var17) {
                        CFG.exceptionStack(var17);
                    }
                } catch (GdxRuntimeException var18) {
                    ex = var18;
                    CFG.exceptionStack(ex);
                }
            }

            FileHandle[] files = Gdx.files.internal("map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + loadScenarioEventsTag + "/" + "events/" + sEventsPath).list();
            FileHandle[] var22 = files;
            i = files.length;

            for(iSize = 0; iSize < i; ++iSize) {
                tempFileEvent = var22[iSize];

                try {
                    loadEvent(eventsType, tempFileEvent.readString().split("\\r?\\n"));
                } catch (Exception var13) {
                    CFG.exceptionStack(var13);
                }
            }


            FileHandle[] var24;
            int var26;
            FileHandle file;
            for(i = 0; i < SteamManager.modsFoldersSize; ++i) {
                if (FileManager.IS_MAC) {
                    files = Gdx.files.external(SteamManager.modsFolders.get(i) + "map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + loadScenarioEventsTag + "/" + "events/" + sEventsPath).list();
                } else {
                    files = Gdx.files.internal(SteamManager.modsFolders.get(i) + "map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + loadScenarioEventsTag + "/" + "events/" + sEventsPath).list();
                }

                var24 = files;
                iSize = files.length;

                for(var26 = 0; var26 < iSize; ++var26) {
                    file = var24[var26];

                    try {
                        loadEvent(eventsType, file.readString().split("\\r?\\n"));
                    } catch (Exception var12) {
                        ex = var12;
                        CFG.exceptionStack(ex);
                    }
                }
            }

            for(i = 0; i < SteamManager.itemsInstalledSize; ++i) {
                files = Gdx.files.absolute(SteamManager.itemsInstalled.get(i).getFolder() + "/" + "map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + loadScenarioEventsTag + "/" + "events/" + sEventsPath).list();
                var24 = files;
                iSize = files.length;

                for(var26 = 0; var26 < iSize; ++var26) {
                    file = var24[var26];

                    try {
                        loadEvent(eventsType, file.readString().split("\\r?\\n"));
                    } catch (Exception var11) {
                        ex = var11;
                        CFG.exceptionStack(ex);
                    }
                }
            }
        } else {
            try {
                try {
                    if (FileManager.loadFile("map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + loadScenarioEventsTag + "/" + "events/").exists()) {
                        tempFileT = FileManager.loadFile("map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + loadScenarioEventsTag + "/" + "events/" + sEventsPath_List);
                        tempSplit = tempFileT.readString().split(";");
                        i = 0;

                        for(iSize = tempSplit.length; i < iSize; ++i) {
                            try {
                                if (!tempSplit[i].isEmpty()) {
                                    tempFileEvent = FileManager.loadFile("map/" + Game.map.getFile_ActiveMap_Path() + "scenarios/" + loadScenarioEventsTag + "/" + "events/" + sEventsPath + tempSplit[i]);
                                    loadEvent(eventsType, tempFileEvent.readString().split("\\r?\\n"));
                                }
                            } catch (Exception var10) {
                                ex = var10;
                                CFG.exceptionStack(ex);
                            }
                        }
                    }
                } catch (Exception var15) {
                    CFG.exceptionStack(var15);
                }
            } catch (GdxRuntimeException var16) {
                ex = var16;
                CFG.exceptionStack(ex);
            }
        }

        if (eventsType == 0) {
            iEventsSize = events.size();
        } else if (eventsType == 1) {
            iEventsSiegeSize = eventsSiege.size();
        } else if (eventsType == 2) {
            iEventsGlobalSize = eventsGlobal.size();
            GameValues.events.RUN_GLOBAL_EVENTS_EVERY_X_TURNS = Math.max(10, GameValues.events.RUN_GLOBAL_EVENTS_EVERY_X_TURNS / Math.max(1, iEventsGlobalSize));
        }

        if (eventsType == 3) {
            iEventsScenarioSize = eventsScenario.size();
        } else if (eventsType == 4) {
            iEventsSiegeScenarioSize = eventsSiegeScenario.size();
        } else if (eventsType == 5) {
            iEventsGlobalScenarioSize = eventsGlobalScenario.size();
        }

    }

    public static Event loadEvent(int eventsType, String[] sSplit) {
        try {
            int iSize = sSplit.length;
            boolean exactDate = false;
            int exactDay = 1;
            int exactMonth = 1;
            int exactYear = 1;
            if (iSize > 1) {
                Event nEvent = new Event();
                boolean inTrigger = false;
                boolean inOption = false;
                EventTrigger trigger = new EventTrigger();
                EventOption option = new EventOption();
                int nextType = 0;
                int triggerType = 0;
                int i = 0;

                while(true) {
                    if (i >= iSize) {
                        if (!nEvent.addEvent()) {
                            break;
                        }

                        if (eventsType != 999 && eventsType != 1000) {
                            if (eventsType == 0) {
                                events.add(nEvent);
                                if (exactDate) {
                                    exactDate_Events.add(new Event_ExactDate(events.size() - 1, exactDay, exactMonth, exactYear));
                                }
                            } else if (eventsType == 1) {
                                eventsSiege.add(nEvent);
                            } else if (eventsType == 2) {
                                eventsGlobal.add(nEvent);
                            } else if (eventsType == 3) {
                                eventsScenario.add(nEvent);
                                if (exactDate) {
                                    exactDate_EventsScenario.add(new Event_ExactDate(eventsScenario.size() - 1, exactDay, exactMonth, exactYear));
                                }
                            } else if (eventsType == 4) {
                                eventsSiegeScenario.add(nEvent);
                            } else if (eventsType == 5) {
                                eventsGlobalScenario.add(nEvent);
                            }
                            break;
                        }

                        return nEvent;
                    }
                    if(sSplit[i].trim().startsWith("#")){
                        //跳过注释
                        continue;
                    }
                    try {
                        String[] sLine = sSplit[i].split("=");
                        if (sLine.length == 1) {
                            if (!sLine[0].isEmpty()) {
                                if (inTrigger) {
                                    switch (sLine[0]) {
                                        case "trigger_and_end":
                                        case "trigger_and_not_end":
                                        case "trigger_or_end":
                                        case "trigger_or_not_end":
                                            inTrigger = false;
                                            nEvent.addTrigger(trigger, triggerType);
                                            break;
                                        case "next_and":
                                            nextType = 0;
                                            break;
                                        case "next_and_not":
                                            nextType = 1;
                                            break;
                                        case "next_or":
                                            nextType = 2;
                                            break;
                                        case "next_or_not":
                                            nextType = 3;
                                            break;
                                        default:
                                            CFG.LOG(" MISSING LEN=1 IN TRIGGER -> " + sLine[0] + " *** Line: " + (i + 1));
                                    }
                                } else if (inOption) {
                                    switch (sLine[0]) {
                                        case "option_end":
                                            inOption = false;
                                            nEvent.options.add(option);
                                            break;
                                        case "next_and":
                                            nextType = 0;
                                            break;
                                        case "next_and_not":
                                            nextType = 1;
                                            break;
                                        case "next_or":
                                            nextType = 2;
                                            break;
                                        case "next_or_not":
                                            nextType = 3;
                                            break;
                                        default:
                                            CFG.LOG(" MISSING LEN=1 IN TRIGGER -> " + sLine[0] + " *** Line: " + (i + 1));
                                    }
                                } else {
                                    switch (sLine[0]) {
                                        case "trigger_and":
                                            triggerType = 0;
                                            inTrigger = true;
                                            trigger = new EventTrigger();
                                            break;
                                        case "trigger_and_not":
                                            triggerType = 1;
                                            inTrigger = true;
                                            trigger = new EventTrigger();
                                            break;
                                        case "trigger_or":
                                            triggerType = 2;
                                            inTrigger = true;
                                            trigger = new EventTrigger();
                                            break;
                                        case "trigger_or_not":
                                            triggerType = 3;
                                            inTrigger = true;
                                            trigger = new EventTrigger();
                                            break;
                                        case "option_btn":
                                            inOption = true;
                                            option = new EventOption();
                                            break;
                                        default:
                                            CFG.LOG(" MISSING LEN=1 -> " + sLine[0] + " *** Line: " + (i + 1));
                                    }
                                }
                            }
                        } else if (sLine.length > 1) {
                            if (inTrigger) {
                                switch (sLine[0]) {
                                    case "random_chance":
                                        trigger.addTrigger(new EventTrigger_RandomChance(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "invested_in_economy_over":
                                        trigger.addTrigger(new EventTrigger_InvestedInEconomyOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "invested_in_economy_below":
                                        trigger.addTrigger(new EventTrigger_InvestedInEconomyBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "developed_infrastructure_over":
                                        trigger.addTrigger(new EventTrigger_DevelopedInfrastructureOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "developed_infrastructure_below":
                                        trigger.addTrigger(new EventTrigger_DevelopedInfrastructureBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_conquered_provinces_over":
                                        trigger.addTrigger(new EventTrigger_ConqueredProvincesOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_conquered_provinces_below":
                                        trigger.addTrigger(new EventTrigger_ConqueredProvincesBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_wars_total_over":
                                        trigger.addTrigger(new EventTrigger_CivWarsTotalOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_wars_total_below":
                                        trigger.addTrigger(new EventTrigger_CivWarsTotalBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "increased_growth_rate_over":
                                        trigger.addTrigger(new EventTrigger_IncreasedGrowthRateOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "increased_growth_rate_below":
                                        trigger.addTrigger(new EventTrigger_IncreasedGrowthRateBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "increased_tax_efficiency_over":
                                        trigger.addTrigger(new EventTrigger_IncreasedTaxEfficiencyOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "increased_tax_efficiency_below":
                                        trigger.addTrigger(new EventTrigger_IncreasedTaxEfficiencyBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "increased_manpower_over":
                                        trigger.addTrigger(new EventTrigger_IncreasedManpowerOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "increased_manpower_below":
                                        trigger.addTrigger(new EventTrigger_IncreasedManpowerBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_has_resource":
                                        trigger.addTrigger(new EventTrigger_CivHasResource(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_has_resource_over":
                                    case "civ_production_over":
                                        if (sLine.length > 2) {
                                            trigger.addTrigger(new EventTrigger_CivHasResourceOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        }
                                        break;
                                    case "province_economy_over":
                                        trigger.addTrigger(new EventTrigger_ProvinceEconomyOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_economy_below":
                                        trigger.addTrigger(new EventTrigger_ProvinceEconomyBelow(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_growth_rate_over":
                                        trigger.addTrigger(new EventTrigger_ProvinceGrowthRateOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_growth_rate_below":
                                        trigger.addTrigger(new EventTrigger_ProvinceGrowthRateBelow(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_tax_efficiency_over":
                                        trigger.addTrigger(new EventTrigger_ProvinceTaxEfficiencyOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_tax_efficiency_below":
                                        trigger.addTrigger(new EventTrigger_ProvinceTaxEfficiencyBelow(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_population_over":
                                        trigger.addTrigger(new EventTrigger_ProvincePopulationOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_population_below":
                                        trigger.addTrigger(new EventTrigger_ProvincePopulationBelow(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_manpower_over":
                                        trigger.addTrigger(new EventTrigger_ProvinceManpowerOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_manpower_below":
                                        trigger.addTrigger(new EventTrigger_ProvinceManpowerBelow(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_income_over":
                                        trigger.addTrigger(new EventTrigger_ProvinceIncomeOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_income_below":
                                        trigger.addTrigger(new EventTrigger_ProvinceIncomeBelow(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_religion_is":
                                        trigger.addTrigger(new EventTrigger_ProvinceReligionIs(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2])), nextType);
                                        break;
                                    case "province_religion_is_not":
                                        trigger.addTrigger(new EventTrigger_ProvinceReligionIsNot(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2])), nextType);
                                        break;
                                    case "province_unrest_over":
                                        trigger.addTrigger(new EventTrigger_ProvinceUnrestOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_unrest_below":
                                        trigger.addTrigger(new EventTrigger_ProvinceUnrestBelow(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_infrastructure_over":
                                        trigger.addTrigger(new EventTrigger_ProvinceInfrastructureOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_infrastructure_below":
                                        trigger.addTrigger(new EventTrigger_ProvinceInfrastructureBelow(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_buildings_over":
                                        trigger.addTrigger(new EventTrigger_ProvinceBuildingsOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_buildings_below":
                                        trigger.addTrigger(new EventTrigger_ProvinceBuildingsBelow(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_defense_lvl_over":
                                        trigger.addTrigger(new EventTrigger_ProvinceDefenseLevelOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_defense_lvl_below":
                                        trigger.addTrigger(new EventTrigger_ProvinceDefenseLevelBelow(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_civ_has_core":
                                        trigger.addTrigger(new EventTrigger_ProvinceCivHasCore(Integer.parseInt(sLine[1]), sLine[2]), nextType);
                                        break;
                                    case "province_controlled_by":
                                        trigger.addTrigger(new EventTrigger_ProvinceControlledByCiv(Integer.parseInt(sLine[1]), sLine[2]), nextType);
                                        break;
                                    case "province_not_controlled_by":
                                        trigger.addTrigger(new EventTrigger_ProvinceControlledByCivNot(Integer.parseInt(sLine[1]), sLine[2]), nextType);
                                        break;
                                    case "province_has_building":
                                        trigger.addTrigger(new EventTrigger_ProvinceHasBuilding(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3])), nextType);
                                        break;
                                    case "civ_capital_has_building":
                                        trigger.addTrigger(new EventTrigger_CivCapital_HasBuilding(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2])), nextType);
                                        break;
                                    case "civ_capital_religion_is":
                                        trigger.addTrigger(new EventTrigger_CivCapital_ReligionIs(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "province_buildings_limit_over":
                                        trigger.addTrigger(new EventTrigger_ProvinceBuildingsLimitOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_buildings_limit_below":
                                        trigger.addTrigger(new EventTrigger_ProvinceBuildingsBelow(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        break;
                                    case "province_is_capital":
                                        trigger.addTrigger(new EventTrigger_ProvinceIsCapital(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "province_is_occupied":
                                        trigger.addTrigger(new EventTrigger_ProvinceIsOccupied(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "province_is_not_occupied":
                                        trigger.addTrigger(new EventTrigger_ProvinceIsOccupiedNot(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "province_is_under_siege":
                                        trigger.addTrigger(new EventTrigger_ProvinceIsUnderSiege(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "buildings_constructed_over":
                                        trigger.addTrigger(new EventTrigger_Buildings_ConstructedOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "buildings_constructed_below":
                                        trigger.addTrigger(new EventTrigger_Buildings_ConstructedBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "administrative_buildings_constructed_over":
                                        trigger.addTrigger(new EventTrigger_Buildings_ConstructedAdministrativeOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "administrative_buildings_constructed_below":
                                        trigger.addTrigger(new EventTrigger_Buildings_ConstructedAdministrativeBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "economy_buildings_constructed_over":
                                        trigger.addTrigger(new EventTrigger_Buildings_ConstructedEconomyOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "economy_buildings_constructed_below":
                                        trigger.addTrigger(new EventTrigger_Buildings_ConstructedEconomyBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "military_buildings_constructed_over":
                                        trigger.addTrigger(new EventTrigger_Buildings_ConstructedMilitaryOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "military_buildings_constructed_below":
                                        trigger.addTrigger(new EventTrigger_Buildings_ConstructedMilitaryBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "unique_capital_buildings_constructed_over":
                                        trigger.addTrigger(new EventTrigger_Buildings_ConstructedCapitalOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "unique_capital_buildings_constructed_below":
                                        trigger.addTrigger(new EventTrigger_Buildings_ConstructedCapitalBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "playing_time_over":
                                        trigger.addTrigger(new EventTrigger_PlayingTimeOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "playing_time_below":
                                        trigger.addTrigger(new EventTrigger_PlayingTimeBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "year_over":
                                        trigger.addTrigger(new EventTrigger_YearOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "year_below":
                                        trigger.addTrigger(new EventTrigger_YearBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "exact_day":
                                        trigger.addTrigger(new EventTrigger_ExactDay(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3])), nextType);
                                        exactDate = true;
                                        exactDay = Integer.parseInt(sLine[1]);
                                        exactMonth = Integer.parseInt(sLine[2]);
                                        exactYear = Integer.parseInt(sLine[3]);
                                        break;
                                    case "civ_provinces_over":
                                        trigger.addTrigger(new EventTrigger_CivProvincesOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_provinces_below":
                                        trigger.addTrigger(new EventTrigger_CivProvincesBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_provinces_equals":
                                        trigger.addTrigger(new EventTrigger_CivProvincesEquals(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_population_over":
                                        trigger.addTrigger(new EventTrigger_CivPopulationOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_population_below":
                                        trigger.addTrigger(new EventTrigger_CivPopulationBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_economy_over":
                                        trigger.addTrigger(new EventTrigger_CivEconomyOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_economy_below":
                                        trigger.addTrigger(new EventTrigger_CivEconomyBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_buildings_over":
                                        trigger.addTrigger(new EventTrigger_CivCapital_BuildingsOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_buildings_below":
                                        trigger.addTrigger(new EventTrigger_CivCapital_BuildingsBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_tax_efficiency_over":
                                        trigger.addTrigger(new EventTrigger_CivCapital_TaxEfficiencyOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_tax_efficiency_below":
                                        trigger.addTrigger(new EventTrigger_CivCapital_TaxEfficiencyBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_continent_is":
                                        trigger.addTrigger(new EventTrigger_CivCapital_ContinentIs(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_continent_is_not":
                                        trigger.addTrigger(new EventTrigger_CivCapital_ContinentIsNot(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_economy_over":
                                        trigger.addTrigger(new EventTrigger_CivCapital_EconomyOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_economy_below":
                                        trigger.addTrigger(new EventTrigger_CivCapital_EconomyBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_manpower_over":
                                        trigger.addTrigger(new EventTrigger_CivCapital_ManpowerOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_manpower_below":
                                        trigger.addTrigger(new EventTrigger_CivCapital_ManpowerBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_unrest_over":
                                        trigger.addTrigger(new EventTrigger_CivCapital_UnrestOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_unrest_below":
                                        trigger.addTrigger(new EventTrigger_CivCapital_UnrestBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_growth_rate_over":
                                        trigger.addTrigger(new EventTrigger_CivCapital_GrowthRateOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_growth_rate_below":
                                        trigger.addTrigger(new EventTrigger_CivCapital_GrowthRateBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_income_over":
                                        trigger.addTrigger(new EventTrigger_CivCapital_IncomeOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_income_below":
                                        trigger.addTrigger(new EventTrigger_CivCapital_IncomeBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_infrastructure_over":
                                        trigger.addTrigger(new EventTrigger_CivCapital_InfrastructureOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_infrastructure_below":
                                        trigger.addTrigger(new EventTrigger_CivCapital_InfrastructureBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_population_over":
                                        trigger.addTrigger(new EventTrigger_CivCapital_PopulationOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_population_below":
                                        trigger.addTrigger(new EventTrigger_CivCapital_PopulationBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_fort_level_over":
                                        trigger.addTrigger(new EventTrigger_CivCapital_FortLevelOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_fort_level_below":
                                        trigger.addTrigger(new EventTrigger_CivCapital_FortLevelBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_is_occupied":
                                        trigger.addTrigger(new EventTrigger_CivCapital_IsOccupied(), nextType);
                                        break;
                                    case "civ_capital_is_not_occupied":
                                        trigger.addTrigger(new EventTrigger_CivCapital_IsOccupiedNot(), nextType);
                                        break;
                                    case "civ_capital_is_under_siege":
                                        trigger.addTrigger(new EventTrigger_CivCapital_IsUnderSiege(), nextType);
                                        break;
                                    case "civ_gold_over":
                                        trigger.addTrigger(new EventTrigger_CivGoldOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_gold_below":
                                        trigger.addTrigger(new EventTrigger_CivGoldBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_religion_is":
                                        trigger.addTrigger(new EventTrigger_CivReligionIs(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_government_is":
                                        trigger.addTrigger(new EventTrigger_CivGovernmentIs(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_allies_over":
                                        trigger.addTrigger(new EventTrigger_CivAlliesOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_allies_below":
                                        trigger.addTrigger(new EventTrigger_CivAlliesBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_defensive_pacts_over":
                                        trigger.addTrigger(new EventTrigger_CivDefensivePactsOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_defensive_pacts_below":
                                        trigger.addTrigger(new EventTrigger_CivDefensivePactsBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_non_aggression_pacts_over":
                                        trigger.addTrigger(new EventTrigger_CivNonAggressionPactsOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_non_aggression_pacts_below":
                                        trigger.addTrigger(new EventTrigger_CivNonAggressionPactsBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_vassals_over":
                                        trigger.addTrigger(new EventTrigger_CivVassalsOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_vassals_below":
                                        trigger.addTrigger(new EventTrigger_CivVassalsBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_neighbors_over":
                                        trigger.addTrigger(new EventTrigger_CivNeighborsOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_neighbors_below":
                                        trigger.addTrigger(new EventTrigger_CivNeighborsBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_unlocked_legacies_over":
                                        trigger.addTrigger(new EventTrigger_CivUnlockedLegaciesOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_unlocked_legacies_below":
                                        trigger.addTrigger(new EventTrigger_CivUnlockedLegaciesBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_unlocked_technologies_over":
                                        trigger.addTrigger(new EventTrigger_CivUnlockedTechnologiesOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_unlocked_technologies_below":
                                        trigger.addTrigger(new EventTrigger_CivUnlockedTechnologiesBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_unlocked_advantages_over":
                                        trigger.addTrigger(new EventTrigger_CivUnlockedAdvantagesOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_unlocked_advantages_below":
                                        trigger.addTrigger(new EventTrigger_CivUnlockedAdvantagesBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_rank_position_over":
                                        trigger.addTrigger(new EventTrigger_CivRankPositionOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_rank_position_below":
                                        trigger.addTrigger(new EventTrigger_CivRankPositionBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_prestige_over":
                                        trigger.addTrigger(new EventTrigger_CivRankPrestigeOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_prestige_below":
                                        trigger.addTrigger(new EventTrigger_CivRankPrestigeBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "is_civ":
                                        trigger.addTrigger(new EventTrigger_IsCiv(sLine[1]), nextType);
                                        break;
                                    case "civ_battle_width_over":
                                        trigger.addTrigger(new EventTrigger_CivBattleWidthOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_battle_width_below":
                                        trigger.addTrigger(new EventTrigger_CivBattleWidthBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_military_academy_over":
                                        trigger.addTrigger(new EventTrigger_CivMilitaryAcademyOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_military_academy_below":
                                        trigger.addTrigger(new EventTrigger_CivMilitaryAcademyBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_military_academy_for_generals_over":
                                        trigger.addTrigger(new EventTrigger_CivMilitaryAcademyForGeneralsOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_military_academy_for_generals_below":
                                        trigger.addTrigger(new EventTrigger_CivMilitaryAcademyForGeneralsBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_city_over":
                                        trigger.addTrigger(new EventTrigger_CivCapitalCityOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_capital_city_below":
                                        trigger.addTrigger(new EventTrigger_CivCapitalCityBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_supreme_court_over":
                                        trigger.addTrigger(new EventTrigger_CivSupremeCourtOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_supreme_court_below":
                                        trigger.addTrigger(new EventTrigger_CivSupremeCourtBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_nuclear_reactor_over":
                                        trigger.addTrigger(new EventTrigger_CivNuclearReactorOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_nuclear_reactor_below":
                                        trigger.addTrigger(new EventTrigger_CivNuclearReactorBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_regiments_limit_over":
                                        trigger.addTrigger(new EventTrigger_CivRegimentsLimitOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_regiments_limit_below":
                                        trigger.addTrigger(new EventTrigger_CivRegimentsLimitBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_regiments_over":
                                        trigger.addTrigger(new EventTrigger_CivRegimentsOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_regiments_below":
                                        trigger.addTrigger(new EventTrigger_CivRegimentsBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_regiments_over_regiments_limit":
                                        trigger.addTrigger(new EventTrigger_CivRegimentsOverRegimentsLimit(Boolean.parseBoolean(sLine[1])), nextType);
                                        break;
                                    case "civ_gold_over_max_amount_of_gold":
                                        trigger.addTrigger(new EventTrigger_CivGoldOver_MaxAmountOfGold(Boolean.parseBoolean(sLine[1])), nextType);
                                        break;
                                    case "civ_administrative_advisor_skill_over":
                                        trigger.addTrigger(new EventTrigger_CivAdministrativeAdvisorSkillOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_administrative_advisor_skill_below":
                                        trigger.addTrigger(new EventTrigger_CivAdministrativeAdvisorSkillBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_economic_advisor_skill_over":
                                        trigger.addTrigger(new EventTrigger_CivEconomyAdvisorSkillOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_economic_advisor_skill_below":
                                        trigger.addTrigger(new EventTrigger_CivEconomyAdvisorSkillBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_innovation_advisor_skill_over":
                                        trigger.addTrigger(new EventTrigger_CivInnovationAdvisorSkillOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_innovation_advisor_skill_below":
                                        trigger.addTrigger(new EventTrigger_CivInnovationAdvisorSkillBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_military_advisor_skill_over":
                                        trigger.addTrigger(new EventTrigger_CivMilitaryAdvisorSkillOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_military_advisor_skill_below":
                                        trigger.addTrigger(new EventTrigger_CivMilitaryAdvisorSkillBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_advisor_age_over":
                                        if (sLine.length > 2) {
                                            trigger.addTrigger(new EventTrigger_CivAdvisor_AgeOver(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2])), nextType);
                                        }
                                        break;
                                    case "civ_advisor_production_efficiency_over":
                                        if (sLine.length > 2) {
                                            trigger.addTrigger(new EventTrigger_CivAdvisor_ProductionEfficiencyOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        }
                                        break;
                                    case "civ_advisor_construction_cost_over":
                                        if (sLine.length > 2) {
                                            trigger.addTrigger(new EventTrigger_CivAdvisor_ConstructionCostOver(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])), nextType);
                                        }
                                        break;
                                    case "civ_manpower_over":
                                        trigger.addTrigger(new EventTrigger_CivManpowerOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_manpower_below":
                                        trigger.addTrigger(new EventTrigger_CivManpowerBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_max_manpower_over":
                                        trigger.addTrigger(new EventTrigger_CivMaxManpowerOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_max_manpower_below":
                                        trigger.addTrigger(new EventTrigger_CivMaxManpowerBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_manpower_perc_over":
                                        trigger.addTrigger(new EventTrigger_CivManpower_PercOfMax_Over(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_manpower_perc_below":
                                        trigger.addTrigger(new EventTrigger_CivManpower_PercOfMax_Below(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_largest_producer_over":
                                        trigger.addTrigger(new EventTrigger_CivLargestProducerOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "largest_producer_production_over":
                                        trigger.addTrigger(new EventTrigger_LargestProducer_ProductionOver(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2])), nextType);
                                        break;
                                    case "civ_is_largest_producer":
                                        trigger.addTrigger(new EventTrigger_IsLargestProducer(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_legacy_over":
                                        trigger.addTrigger(new EventTrigger_CivLegacyOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_legacy_below":
                                        trigger.addTrigger(new EventTrigger_CivLegacyBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "recruited_advisors_over":
                                        trigger.addTrigger(new EventTrigger_RecruitedAdvisorsOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "recruited_advisors_below":
                                        trigger.addTrigger(new EventTrigger_RecruitedAdvisorsBelow(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_inflation_over":
                                        trigger.addTrigger(new EventTrigger_CivInflationOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_inflation_below":
                                        trigger.addTrigger(new EventTrigger_CivInflationBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "alliance_special_is_leader":
                                        trigger.addTrigger(new EventTrigger_AllianceIsLeader(), nextType);
                                        break;
                                    case "alliance_special_is_leader_id":
                                        trigger.addTrigger(new EventTrigger_AllianceIsLeaderID(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "alliance_special_is_member_id":
                                        trigger.addTrigger(new EventTrigger_AllianceIsInAlliance(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "alliance_special_is_not_member_id":
                                        trigger.addTrigger(new EventTrigger_AllianceIsNotInAlliance(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civ_loans_over":
                                        trigger.addTrigger(new EventTrigger_CivLoansOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_loans_below":
                                        trigger.addTrigger(new EventTrigger_CivLoansBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_total_income_over":
                                        trigger.addTrigger(new EventTrigger_CivIncomeOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_total_income_below":
                                        trigger.addTrigger(new EventTrigger_CivIncomeBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_diplomacy_over":
                                        trigger.addTrigger(new EventTrigger_CivDiplomacyOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_diplomacy_below":
                                        trigger.addTrigger(new EventTrigger_CivDiplomacyBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_legacy_per_month_over":
                                        trigger.addTrigger(new EventTrigger_CivLegacyPerMonthOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_legacy_per_month_below":
                                        trigger.addTrigger(new EventTrigger_CivLegacyPerMonthBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_research_per_month_over":
                                        trigger.addTrigger(new EventTrigger_CivResearchPerMonthOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_research_per_month_below":
                                        trigger.addTrigger(new EventTrigger_CivResearchPerMonthBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_income_taxation_over":
                                        trigger.addTrigger(new EventTrigger_CivIncomeTaxationOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_income_taxation_below":
                                        trigger.addTrigger(new EventTrigger_CivIncomeTaxationBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_income_economy_over":
                                        trigger.addTrigger(new EventTrigger_CivIncomeEconomyOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_income_economy_below":
                                        trigger.addTrigger(new EventTrigger_CivIncomeEconomyBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_income_production_over":
                                        trigger.addTrigger(new EventTrigger_CivIncomeProductionOver(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_income_production_below":
                                        trigger.addTrigger(new EventTrigger_CivIncomeProductionBelow(Float.parseFloat(sLine[1])), nextType);
                                        break;
                                    case "civ_is_at_war":
                                        trigger.addTrigger(new EventTrigger_IsAtWar(), nextType);
                                        break;
                                    case "civ_is_not_at_war":
                                        trigger.addTrigger(new EventTrigger_IsNotAtWar(), nextType);
                                        break;
                                    case "civ_is_at_war_days_over":
                                        trigger.addTrigger(new EventTrigger_IsAtWar_DaysOver(Integer.parseInt(sLine[1])), nextType);
                                        break;
                                    case "civs_are_at_war":
                                        trigger.addTrigger(new EventTrigger_AreAtWar(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civs_are_not_at_war":
                                        trigger.addTrigger(new EventTrigger_AreNotAtWar(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civ_has_more_provinces_than_civ":
                                        trigger.addTrigger(new EventTrigger_CivHasMoreProvinceThanCiv(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civ_has_larger_population_than_civ":
                                        trigger.addTrigger(new EventTrigger_CivHasLargerPopulationThanCiv(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civ_has_larger_economy_than_civ":
                                        trigger.addTrigger(new EventTrigger_CivHasLargerEconomyThanCiv(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civ_has_larger_regiments_limit_than_civ":
                                        trigger.addTrigger(new EventTrigger_CivHasLargerRegimentsLimitThanCiv(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civ_has_more_regiments_than_civ":
                                        trigger.addTrigger(new EventTrigger_CivHasMoreRegimentsThanCiv(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civ_has_higher_ranking_than_civ":
                                        trigger.addTrigger(new EventTrigger_CivHasHigherRankThanCiv(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civ_has_more_technologies_than_civ":
                                        trigger.addTrigger(new EventTrigger_CivHasMoreTechsThanCiv(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civs_are_rivals":
                                        trigger.addTrigger(new EventTrigger_CivsAreRivals(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civ_has_rivalry":
                                        trigger.addTrigger(new EventTrigger_CivRivaledCiv(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civ_has_rivalry_not":
                                        trigger.addTrigger(new EventTrigger_CivRivaledCivNot(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civ_is_vassal_of_civ":
                                        trigger.addTrigger(new EventTrigger_IsVassalOfCiv(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civs_are_neighbors":
                                        trigger.addTrigger(new EventTrigger_CivsAreNeighbors(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civs_are_not_neighbors":
                                        trigger.addTrigger(new EventTrigger_CivsAreNeighborsNot(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civs_opinion_over":
                                        trigger.addTrigger(new EventTrigger_OpinionOver(sLine[1], sLine[2], Float.parseFloat(sLine[3])), nextType);
                                        break;
                                    case "civs_opinion_below":
                                        trigger.addTrigger(new EventTrigger_OpinionBelow(sLine[1], sLine[2], Float.parseFloat(sLine[3])), nextType);
                                        break;
                                    case "civs_have_defensive_pact":
                                        trigger.addTrigger(new EventTrigger_HaveDefensivePact(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civs_have_non_aggression":
                                        trigger.addTrigger(new EventTrigger_HaveNonAggressionPact(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civs_have_alliance":
                                        trigger.addTrigger(new EventTrigger_HaveAlliance(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civs_have_truce":
                                        trigger.addTrigger(new EventTrigger_HaveTruce(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civ_have_guarantee":
                                        trigger.addTrigger(new EventTrigger_HaveGuarantee(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "civ_have_military_access":
                                        trigger.addTrigger(new EventTrigger_HaveMilitaryAccess(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "has_variable":
                                        trigger.addTrigger(new EventTrigger_HasVariable(sLine[1]), nextType);
                                        break;
                                    case "has_variable_not":
                                        trigger.addTrigger(new EventTrigger_HasVariableNot(sLine[1]), nextType);
                                        break;
                                    case "has_variable_civ":
                                        trigger.addTrigger(new EventTrigger_HasVariableCiv(sLine[1], sLine[2]), nextType);
                                        break;
                                    case "is_puppet":
                                        trigger.addTrigger(new EventTrigger_IsVassal(sLine[1]), nextType);
                                        break;
                                    case "is_not_puppet":
                                        trigger.addTrigger(new EventTrigger_IsNotVassal(sLine[1]), nextType);
                                        break;
                                    case "is_player":
                                        trigger.addTrigger(new EventTrigger_IsPlayer(sLine[1]), nextType);
                                        break;
                                    case "is_not_player":
                                        trigger.addTrigger(new EventTrigger_IsNotPlayer(sLine[1]), nextType);
                                        break;
                                    case "exists":
                                        trigger.addTrigger(new EventTrigger_Exists(sLine[1]), nextType);
                                        break;
                                    case "not_exists":
                                        trigger.addTrigger(new EventTrigger_ExistsNot(sLine[1]), nextType);
                                        break;
                                    case "exists_any":
                                        trigger.addTrigger(new EventTrigger_ExistsAny(sLine[1]), nextType);
                                        break;
                                    case "exists_any_not":
                                        trigger.addTrigger(new EventTrigger_ExistsAnyNot(sLine[1]), nextType);
                                        break;
                                    case "civ_tag_religion_is":
                                        trigger.addTrigger(new EventTrigger_CivTag_ReligionIs(sLine[1], Integer.parseInt(sLine[2])), nextType);
                                        break;
                                    case "civ_tag_religion_is_not":
                                        trigger.addTrigger(new EventTrigger_CivTag_ReligionIsNot(sLine[1], Integer.parseInt(sLine[2])), nextType);
                                        break;
                                    case "civ_tag_government_is":
                                        trigger.addTrigger(new EventTrigger_CivTag_GovernmentIs(sLine[1], Integer.parseInt(sLine[2])), nextType);
                                        break;
                                    case "civ_tag_government_is_not":
                                        trigger.addTrigger(new EventTrigger_CivTag_GovernmentIsNot(sLine[1], Integer.parseInt(sLine[2])), nextType);
                                        break;
                                    case "if_counter":
                                        trigger.addTrigger(new EventTrigger_If_Counter(sSplit[i].replaceFirst("if_counter=","")),nextType);
                                        break;
                                    case "et_counter":
                                        trigger.addTrigger(new EventTrigger_EqualTo_Counter(sLine[1],Integer.parseInt(sLine[2])),nextType);
                                        break;
                                    case "lt_counter":
                                        trigger.addTrigger(new EventTrigger_LessThan_Counter(sLine[1],Integer.parseInt(sLine[2])),nextType);
                                        break;
                                    case "mt_counter":
                                        trigger.addTrigger(new EventTrigger_MoreThan_Counter(sLine[1],Integer.parseInt(sLine[2])),nextType);
                                        break;
                                    default:
                                        CFG.LOG(" MISSING IN TRIGGER -> " + sLine[0] + " *** Line: " + (i + 1));
                                }
                            } else if (inOption) {
                                Exception ex;
                                ArrayList nProvinces;
                                int j;
                                String[] tSplit;
                                switch (sLine[0]) {
                                    case "name":
                                        option.name = sLine[1];
                                        break;
                                    case "add_counter":
                                        option.outcome.add(new EventOutcome_Add_Counter(sLine[1],sLine[2],Integer.parseInt(sLine[3])));
                                        break;
                                    case "sub_counter":
                                        option.outcome.add(new EventOutcome_Sub_Counter(sLine[1],sLine[2],Integer.parseInt(sLine[3])));
                                        break;
                                    case "mul_counter":
                                        option.outcome.add(new EventOutcome_Mul_Counter(sLine[1],sLine[2],Integer.parseInt(sLine[3])));
                                        break;
                                    case "div_counter":
                                        option.outcome.add(new EventOutcome_Div_Counter(sLine[1],sLine[2],Integer.parseInt(sLine[3])));
                                        break;
                                    case "set_counter":
                                        option.outcome.add(new EventOutcome_Set_Counter(sLine[1],sLine[2],sLine[3]));
                                        break;
                                    case "gold":
                                        option.outcome.add(new EventOutcome_Gold(Float.parseFloat(sLine[1])));
                                        break;
                                    case "gold_monthly_income":
                                        option.outcome.add(new EventOutcome_Gold_MonthlyIncome(Float.parseFloat(sLine[1])));
                                        break;
                                    case "legacy":
                                        option.outcome.add(new EventOutcome_Legacy(Float.parseFloat(sLine[1])));
                                        break;
                                    case "legacy_monthly":
                                        option.outcome.add(new EventOutcome_Legacy_Monthly(Float.parseFloat(sLine[1])));
                                        break;
                                    case "research":
                                        option.outcome.add(new EventOutcome_Research(Float.parseFloat(sLine[1])));
                                        break;
                                    case "inflation":
                                        option.outcome.add(new EventOutcome_Inflation(Float.parseFloat(sLine[1])));
                                        break;
                                    case "move_capital":
                                        option.outcome.add(new EventOutcome_MoveCapital(Integer.parseInt(sLine[1])));
                                        break;
                                    case "manpower":
                                        option.outcome.add(new EventOutcome_Manpower(Integer.parseInt(sLine[1])));
                                        break;
                                    case "ae_set":
                                        option.outcome.add(new EventOutcome_AggressiveExpansion_Set(Float.parseFloat(sLine[1])));
                                        break;
                                    case "advantage_points":
                                        option.outcome.add(new EventOutcome_AdvantagePoints(Integer.parseInt(sLine[1])));
                                        break;
                                    case "add_variable":
                                        option.outcome.add(new EventOutcome_AddVariable(sLine[1]));
                                        break;
                                    case "add_variable2":
                                        option.outcome.add(new EventOutcome_AddVariable_Civ(sLine[1], sLine[2]));
                                        break;
                                    case "ai_aggression":
                                        option.outcome.add(new EventOutcome_AI_Aggression(Integer.parseInt(sLine[1])));
                                        break;
                                    case "add_new_army":
                                        List<Integer> unitID = new ArrayList();
                                        nProvinces = new ArrayList();

                                        try {
                                            for(j = 1; j < sLine.length - 1; j += 2) {
                                                unitID.add(Integer.parseInt(sLine[j]));
                                                nProvinces.add(Integer.parseInt(sLine[j + 1]));
                                            }
                                        } catch (Exception var41) {
                                            CFG.exceptionStack(var41);
                                        }

                                        option.outcome.add(new EventOutcome_AddArmy(unitID, nProvinces));
                                        break;
                                    case "military_academy":
                                        option.outcome.add(new EventOutcome_MilitaryAcademy(Integer.parseInt(sLine[1])));
                                        break;
                                    case "military_academy_generals":
                                        option.outcome.add(new EventOutcome_MilitaryAcademyForGenerals(Integer.parseInt(sLine[1])));
                                        break;
                                    case "capital_city_level":
                                        option.outcome.add(new EventOutcome_CapitalCityLevel(Integer.parseInt(sLine[1])));
                                        break;
                                    case "supreme_court":
                                        option.outcome.add(new EventOutcome_SupremeCourt(Integer.parseInt(sLine[1])));
                                        break;
                                    case "nuclear_reactor":
                                        option.outcome.add(new EventOutcome_NuclearReactor(Integer.parseInt(sLine[1])));
                                        break;
                                    case "set_civ_tag":
                                        option.outcome.add(new EventOutcome_SetCiv(sLine[1]));
                                        break;
                                    case "set_civ_tag2":
                                        option.outcome.add(new EventOutcome_SetCiv2(sLine[1], sLine[2]));
                                        break;
                                    case "set_civ_tag_reset":
                                        option.outcome.add(new EventOutcome_SetCiv_Reset(sLine[1]));
                                        break;
                                    case "set_civ_tag_reset2":
                                        option.outcome.add(new EventOutcome_SetCiv_Reset2(sLine[1], sLine[2]));
                                        break;
                                    case "declare_war":
                                        option.outcome.add(new EventOutcome_DeclareWar(sLine[1]));
                                        break;
                                    case "declare_war2":
                                        option.outcome.add(new EventOutcome_DeclareWar2(sLine[1], sLine[2]));
                                        break;
                                    case "player_set_civ":
                                        option.outcome.add(new EventOutcome_PlayerChangeCiv(sLine[1]));
                                        break;
                                    case "change_ideology":
                                        option.outcome.add(new EventOutcome_ChangeIdeology(Integer.parseInt(sLine[1])));
                                        break;
                                    case "change_religion":
                                        option.outcome.add(new EventOutcome_ChangeReligion(Integer.parseInt(sLine[1])));
                                        break;
                                    case "change_ideology_civ":
                                        option.outcome.add(new EventOutcome_ChangeIdeologyCiv(Integer.parseInt(sLine[1]), sLine[2]));
                                        break;
                                    case "change_religion_civ":
                                        option.outcome.add(new EventOutcome_ChangeReligionCiv(Integer.parseInt(sLine[1]), sLine[2]));
                                        break;
                                    case "run_event":
                                        option.outcome.add(new EventOutcome_RunEvent(sLine[1]));
                                        break;
                                    case "promote_advisor":
                                        option.outcome.add(new EventOutcome_PromoteAdvisor(Integer.parseInt(sLine[1])));
                                        break;
                                    case "join_alliance_special_id_first_tier":
                                        option.outcome.add(new EventOutcome_JoinAllianceSpecialFirstTier(Integer.parseInt(sLine[1])));
                                        break;
                                    case "join_alliance_special_id_second_tier":
                                        option.outcome.add(new EventOutcome_JoinAllianceSpecialSecondTier(Integer.parseInt(sLine[1])));
                                        break;
                                    case "leave_alliance_special_id":
                                        option.outcome.add(new EventOutcome_LeaveAllianceSpecial(Integer.parseInt(sLine[1])));
                                        break;
                                    case "kill_advisor":
                                        option.outcome.add(new EventOutcome_KillAdvisor(Integer.parseInt(sLine[1])));
                                        break;
                                    case "kill_ruler":
                                        option.outcome.add(new EventOutcome_KillRuler());
                                        break;
                                    case "kill_ruler_chance":
                                        option.outcome.add(new EventOutcome_KillRuler_Chance(Float.parseFloat(sLine[1])));
                                        break;
                                    case "add_general":
                                        option.outcome.add(new EventOutcome_AddGeneral());
                                        break;
                                    case "price_change":
                                        option.outcome.add(new EventOutcome_Resource_PriceChange(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]), Integer.parseInt(sLine[4]), Integer.parseInt(sLine[5])));
                                        break;
                                    case "price_change_up":
                                        option.outcome.add(new EventOutcome_Resource_PriceChangeUp(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]), Integer.parseInt(sLine[4]), Integer.parseInt(sLine[5])));
                                        break;
                                    case "price_change_down":
                                        option.outcome.add(new EventOutcome_Resource_PriceChangeDown(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]), Integer.parseInt(sLine[4]), Integer.parseInt(sLine[5])));
                                        break;
                                    case "price_change_group":
                                        option.outcome.add(new EventOutcome_Resource_PriceChangeGroup(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]), Integer.parseInt(sLine[4]), Integer.parseInt(sLine[5])));
                                        break;
                                    case "price_change_group_up":
                                        option.outcome.add(new EventOutcome_Resource_PriceChangeGroupUp(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]), Integer.parseInt(sLine[4]), Integer.parseInt(sLine[5])));
                                        break;
                                    case "price_change_group_down":
                                        option.outcome.add(new EventOutcome_Resource_PriceChangeGroupDown(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]), Integer.parseInt(sLine[4]), Integer.parseInt(sLine[5])));
                                        break;
                                    case "price_change_random":
                                        option.outcome.add(new EventOutcome_Resource_PriceChangeRandom(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]), Integer.parseInt(sLine[4])));
                                        break;
                                    case "price_change_random_up":
                                        option.outcome.add(new EventOutcome_Resource_PriceChangeRandomUp(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]), Integer.parseInt(sLine[4])));
                                        break;
                                    case "price_change_random_down":
                                        option.outcome.add(new EventOutcome_Resource_PriceChangeRandomDown(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]), Integer.parseInt(sLine[4])));
                                        break;
                                    case "add_general2":
                                        option.outcome.add(new EventOutcome_AddGeneral_Character(sLine[1]));
                                        break;
                                    case "add_general3":
                                        option.outcome.add(new EventOutcome_AddGeneral_CharacterAttackDefense(sLine[1], Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3])));
                                        break;
                                    case "add_ruler":
                                        try {
                                            option.outcome.add(new EventOutcome_AddRuler(sLine[1], sLine[2], sLine[3], Integer.parseInt(sLine[4]), Integer.parseInt(sLine[5]), Integer.parseInt(sLine[6])));
                                        } catch (Exception var37) {
                                            ex = var37;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "add_advisor":
                                        option.outcome.add(new EventOutcome_AddAdvisor(Integer.parseInt(sLine[1])));
                                        break;
                                    case "add_advisor2":
                                        option.outcome.add(new EventOutcome_AddAdvisor_Character(sLine[2], Integer.parseInt(sLine[1])));
                                        break;
                                    case "annex":
                                        try {
                                            if (sLine.length > 1 && sLine[1] != null && !sLine[1].isEmpty()) {
                                                tSplit = sLine[1].split(";");
                                                nProvinces = new ArrayList();

                                                for(j = 0; j < tSplit.length; ++j) {
                                                    try {
                                                        nProvinces.add(Integer.parseInt(tSplit[j]));
                                                    } catch (Exception var36) {
                                                        ex = var36;
                                                        CFG.exceptionStack(ex);
                                                    }
                                                }

                                                if (!nProvinces.isEmpty()) {
                                                    option.outcome.add(new EventOutcome_AnnexProvinces(nProvinces));
                                                }
                                            }
                                        } catch (Exception var40) {
                                            ex = var40;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "annex_from_civ":
                                        try {
                                            if (sLine.length > 2 && sLine[2] != null && !sLine[2].isEmpty() && !sLine[1].isEmpty()) {
                                                tSplit = sLine[2].split(";");
                                                nProvinces = new ArrayList();

                                                for(j = 0; j < tSplit.length; ++j) {
                                                    try {
                                                        nProvinces.add(Integer.parseInt(tSplit[j]));
                                                    } catch (Exception var35) {
                                                        ex = var35;
                                                        CFG.exceptionStack(ex);
                                                    }
                                                }

                                                if (!nProvinces.isEmpty()) {
                                                    option.outcome.add(new EventOutcome_AnnexProvincesFromCiv(sLine[1], nProvinces));
                                                }
                                            }
                                        } catch (Exception var39) {
                                            ex = var39;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "annex_by_civ_from_civ":
                                        try {
                                            if (sLine.length > 3 && sLine[3] != null && !sLine[3].isEmpty()) {
                                                tSplit = sLine[3].split(";");
                                                nProvinces = new ArrayList();

                                                for(j = 0; j < tSplit.length; ++j) {
                                                    try {
                                                        nProvinces.add(Integer.parseInt(tSplit[j]));
                                                    } catch (Exception var34) {
                                                        ex = var34;
                                                        CFG.exceptionStack(ex);
                                                    }
                                                }

                                                if (!nProvinces.isEmpty()) {
                                                    option.outcome.add(new EventOutcome_AnnexedProvincesByCivFromCiv(sLine[1], sLine[2], nProvinces));
                                                }
                                            }
                                        } catch (Exception var38) {
                                            ex = var38;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "make_puppet":
                                        try {
                                            option.outcome.add(new EventOutcome_Vassalize(sLine[1], sLine[2]));
                                        } catch (Exception var33) {
                                            ex = var33;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "annex_civ":
                                        try {
                                            if (sLine.length > 1 && sLine[1] != null && !sLine[1].isEmpty()) {
                                                option.outcome.add(new EventOutcome_AnnexCivilization(sLine[1]));
                                            }
                                        } catch (Exception var32) {
                                            ex = var32;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "annexed_by_civ":
                                        try {
                                            if (sLine.length > 1 && sLine[1] != null && !sLine[1].isEmpty()) {
                                                option.outcome.add(new EventOutcome_AnnexedByCivilization(sLine[1]));
                                            }
                                        } catch (Exception var31) {
                                            ex = var31;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "add_alliance":
                                        try {
                                            option.outcome.add(new EventOutcome_Alliance(sLine[1], sLine[2]));
                                        } catch (Exception var30) {
                                            ex = var30;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "white_peace":
                                        try {
                                            option.outcome.add(new EventOutcome_WhitePeace(sLine[1], sLine[2]));
                                        } catch (Exception var30) {
                                            ex = var30;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "unlock_tech":
                                        try {
                                            option.outcome.add(new EventOutcome_Unlock_Tech(Integer.parseInt(sLine[1])));
                                        } catch (Exception var30) {
                                            ex = var30;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "remove_alliance":
                                        try {
                                            option.outcome.add(new EventOutcome_RemoveAlliance(sLine[1], sLine[2]));
                                        } catch (Exception var30) {
                                            ex = var30;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "explode":
                                        try {
                                            option.outcome.add(new EventOutcome_Explode(sLine[1]));
                                        } catch (Exception var29) {
                                            ex = var29;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "relations_change":
                                        try {
                                            option.outcome.add(new EventOutcome_RelationChange(sLine[1], sLine[2], Float.parseFloat(sLine[3])));
                                        } catch (Exception var28) {
                                            ex = var28;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "relations_set":
                                        try {
                                            option.outcome.add(new EventOutcome_RelationSet(sLine[1], sLine[2], Float.parseFloat(sLine[3])));
                                        } catch (Exception var27) {
                                            ex = var27;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "add_non_aggression":
                                        try {
                                            option.outcome.add(new EventOutcome_NonAggressionPact(sLine[1], sLine[2]));
                                        } catch (Exception var26) {
                                            ex = var26;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "add_military_access":
                                        try {
                                            option.outcome.add(new EventOutcome_MilitaryAccess(sLine[1], sLine[2]));
                                        } catch (Exception var25) {
                                            ex = var25;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "add_guarantee":
                                        try {
                                            option.outcome.add(new EventOutcome_Guarantee(sLine[1], sLine[2]));
                                        } catch (Exception var24) {
                                            ex = var24;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "add_defensive_pact":
                                        try {
                                            option.outcome.add(new EventOutcome_DefensivePact(sLine[1], sLine[2]));
                                        } catch (Exception var23) {
                                            ex = var23;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "add_truce":
                                        try {
                                            option.outcome.add(new EventOutcome_AddTruce(sLine[1], sLine[2]));
                                        } catch (Exception var22) {
                                            ex = var22;
                                            CFG.exceptionStack(ex);
                                        }
                                        break;
                                    case "ai":
                                        option.ai = Float.parseFloat(sLine[1]);
                                        break;
                                    case "play_music":
                                        option.outcome.add(new EventOutcome_PlayMusic(sLine[1]));
                                        break;
                                    case "province_add_core_civ":
                                        option.outcome.add(new EventOutcome_Province_ID_CoreAdd(sLine[1], sLine[2]));
                                        break;
                                    case "province_remove_core_civ":
                                        option.outcome.add(new EventOutcome_Province_ID_CoreRemove(sLine[1], sLine[2]));
                                        break;
                                    case "province_economy":
                                        option.outcome.add(new EventOutcome_Province_Economy(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_economy_id":
                                        option.outcome.add(new EventOutcome_Province_Economy_ID(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])));
                                        break;
                                    case "province_economy_capital":
                                        option.outcome.add(new EventOutcome_Province_Economy_Capital(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_economy_all":
                                        option.outcome.add(new EventOutcome_Province_Economy_All(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_tax_efficiency":
                                        option.outcome.add(new EventOutcome_Province_TaxEfficiency(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_tax_efficiency_id":
                                        option.outcome.add(new EventOutcome_Province_TaxEfficiency_ID(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])));
                                        break;
                                    case "province_tax_efficiency_capital":
                                        option.outcome.add(new EventOutcome_Province_TaxEfficiency_Capital(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_tax_efficiency_all":
                                        option.outcome.add(new EventOutcome_Province_TaxEfficiency_All(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_manpower":
                                        option.outcome.add(new EventOutcome_Province_Manpower(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_manpower_capital":
                                        option.outcome.add(new EventOutcome_Province_Manpower_Capital(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_manpower_all":
                                        option.outcome.add(new EventOutcome_Province_Manpower_All(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_manpower_id":
                                        option.outcome.add(new EventOutcome_Province_Manpower_ID(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])));
                                        break;
                                    case "province_growth_rate":
                                        option.outcome.add(new EventOutcome_Province_GrowthRate(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_growth_rate_capital":
                                        option.outcome.add(new EventOutcome_Province_GrowthRate_Capital(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_growth_rate_all":
                                        option.outcome.add(new EventOutcome_Province_GrowthRate_All(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_growth_rate_id":
                                        option.outcome.add(new EventOutcome_Province_GrowthRate_ID(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])));
                                        break;
                                    case "province_population":
                                        option.outcome.add(new EventOutcome_Province_Population(Integer.parseInt(sLine[1])));
                                        break;
                                    case "province_population_capital":
                                        option.outcome.add(new EventOutcome_Province_Population_Capital(Integer.parseInt(sLine[1])));
                                        break;
                                    case "province_population_all":
                                        option.outcome.add(new EventOutcome_Province_Population_All(Integer.parseInt(sLine[1])));
                                        break;
                                    case "province_religion":
                                        option.outcome.add(new EventOutcome_Province_Religion(Integer.parseInt(sLine[1])));
                                        break;
                                    case "province_religion_capital":
                                        option.outcome.add(new EventOutcome_Province_Religion_Capital(Integer.parseInt(sLine[1])));
                                        break;
                                    case "province_religion_all":
                                        option.outcome.add(new EventOutcome_Province_Religion_All(Integer.parseInt(sLine[1])));
                                        break;
                                    case "province_religion_id":
                                        option.outcome.add(new EventOutcome_Province_Religion_ID(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2])));
                                        break;
                                    case "province_devastation":
                                        option.outcome.add(new EventOutcome_Province_Devastation(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_devastation_capital":
                                        option.outcome.add(new EventOutcome_Province_Devastation_Capital(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_devastation_all":
                                        option.outcome.add(new EventOutcome_Province_Devastation_All(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_devastation_id":
                                        option.outcome.add(new EventOutcome_Province_Devastation_ID(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])));
                                        break;
                                    case "province_unrest":
                                        option.outcome.add(new EventOutcome_Province_Unrest(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_unrest_capital":
                                        option.outcome.add(new EventOutcome_Province_Unrest_Capital(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_unrest_all":
                                        option.outcome.add(new EventOutcome_Province_Unrest_All(Float.parseFloat(sLine[1])));
                                        break;
                                    case "province_unrest_id":
                                        option.outcome.add(new EventOutcome_Province_Unrest_ID(Integer.parseInt(sLine[1]), Float.parseFloat(sLine[2])));
                                        break;
                                    case "province_infrastructure":
                                        option.outcome.add(new EventOutcome_Province_Infrastructure(Integer.parseInt(sLine[1])));
                                        break;
                                    case "province_infrastructure_capital":
                                        option.outcome.add(new EventOutcome_Province_Infrastructure_Capital(Integer.parseInt(sLine[1])));
                                        break;
                                    case "province_infrastructure_all":
                                        option.outcome.add(new EventOutcome_Province_Infrastructure_All(Integer.parseInt(sLine[1])));
                                        break;
                                    case "province_infrastructure_id":
                                        option.outcome.add(new EventOutcome_Province_Infrastructure_ID(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2])));
                                        break;
                                    case "bonus_duration":
                                        option.bonus_duration = Integer.parseInt(sLine[1]);
                                        break;
                                    case "bonus_monthly_income":
                                        option.outcome.add(new EventOutcome_BonusMonthlyIncome(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_monthly_legacy":
                                        option.outcome.add(new EventOutcome_BonusMonthlyLegacy(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_monthly_legacy_percentage":
                                        option.outcome.add(new EventOutcome_BonusMonthlyLegacyPerc(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_tax_efficiency":
                                        option.outcome.add(new EventOutcome_BonusTaxEfficiency(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_province_maintenance":
                                        option.outcome.add(new EventOutcome_BonusProvinceMaintenance(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_buildings_maintenance_cost":
                                        option.outcome.add(new EventOutcome_BonusBuildingsMaintenanceCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_maintenance_cost":
                                        option.outcome.add(new EventOutcome_BonusMaintenanceCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_growth_rate":
                                        option.outcome.add(new EventOutcome_BonusGrowthRate(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_corruption":
                                        option.outcome.add(new EventOutcome_BonusCorruption(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_inflation":
                                        option.outcome.add(new EventOutcome_BonusInflation(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_production_efficiency":
                                        option.outcome.add(new EventOutcome_BonusProductionEfficiency(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_income_taxation":
                                        option.outcome.add(new EventOutcome_BonusIncomeTaxation(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_income_economy":
                                        option.outcome.add(new EventOutcome_BonusIncomeEconomy(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_income_production":
                                        option.outcome.add(new EventOutcome_BonusIncomeProduction(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_max_manpower":
                                        option.outcome.add(new EventOutcome_BonusMaxManpower(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_max_manpower_percentage":
                                        option.outcome.add(new EventOutcome_BonusMaxManpowerPercentage(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_manpower_recovery_speed":
                                        option.outcome.add(new EventOutcome_BonusManpowerRecoverySpeed(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_reinforcement_speed":
                                        option.outcome.add(new EventOutcome_BonusReinforcementSpeed(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_army_morale_recovery":
                                        option.outcome.add(new EventOutcome_BonusArmyMoraleRecovery(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_war_score_cost":
                                        option.outcome.add(new EventOutcome_BonusWarScoreCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_army_maintenance":
                                        option.outcome.add(new EventOutcome_BonusArmyMaintenance(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_recruitment_time":
                                        option.outcome.add(new EventOutcome_BonusRecruitmentTime(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_recruit_army_cost":
                                        option.outcome.add(new EventOutcome_BonusRecruitArmyCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_recruit_army_first_line_cost":
                                        option.outcome.add(new EventOutcome_BonusRecruitArmyFirstLineCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_recruit_army_second_line_cost":
                                        option.outcome.add(new EventOutcome_BonusRecruitArmySecondLineCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_research":
                                        option.outcome.add(new EventOutcome_BonusResearch(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_research_points":
                                        option.outcome.add(new EventOutcome_BonusResearchPoints(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_construction_cost":
                                        option.outcome.add(new EventOutcome_BonusConstructionCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_administration_buildings_cost":
                                        option.outcome.add(new EventOutcome_BonusAdministrationBuildingsCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_military_buildings_cost":
                                        option.outcome.add(new EventOutcome_BonusMilitaryBuildingsCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_economy_buildings_cost":
                                        option.outcome.add(new EventOutcome_BonusEconomyBuildingsCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_construction_time":
                                        option.outcome.add(new EventOutcome_BonusConstructionTime(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_invest_in_economy_cost":
                                        option.outcome.add(new EventOutcome_BonusInvestInEconomyCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_maximum_amount_of_gold":
                                        option.outcome.add(new EventOutcome_BonusMaximumAmountOfGold(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_increase_manpower_cost":
                                        option.outcome.add(new EventOutcome_BonusIncreaseManpowerCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_increase_tax_efficiency_cost":
                                        option.outcome.add(new EventOutcome_BonusIncreaseTaxEfficiencyCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_develop_infrastructure_cost":
                                        option.outcome.add(new EventOutcome_BonusDevelopInfrastructureCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_increase_growth_rate_cost":
                                        option.outcome.add(new EventOutcome_BonusIncreaseGrowthRateCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_generals_attack":
                                        option.outcome.add(new EventOutcome_BonusGeneralAttack(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_generals_defense":
                                        option.outcome.add(new EventOutcome_BonusGeneralDefense(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_units_attack":
                                        option.outcome.add(new EventOutcome_BonusUnitsAttack(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_units_defense":
                                        option.outcome.add(new EventOutcome_BonusUnitsDefense(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_max_morale":
                                        option.outcome.add(new EventOutcome_BonusMaxMorale(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_army_movement_speed":
                                        option.outcome.add(new EventOutcome_BonusArmyMovementSpeed(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_siege_effectiveness":
                                        option.outcome.add(new EventOutcome_BonusSiegeEffectiveness(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_improve_relations_modifier":
                                        option.outcome.add(new EventOutcome_BonusImproveRelationsModifier(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_loan_interest":
                                        option.outcome.add(new EventOutcome_BonusLoanInterest(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_loans_limit":
                                        option.outcome.add(new EventOutcome_BonusLoansLimit(Integer.parseInt(sLine[1])));
                                        break;
                                    case "bonus_aggressive_expansion":
                                        option.outcome.add(new EventOutcome_BonusAggressiveExpansion(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_income_from_vassals":
                                        option.outcome.add(new EventOutcome_BonusIncomeFromVassals(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_revolutionary_risk":
                                        option.outcome.add(new EventOutcome_BonusRevolutionaryRisk(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_core_cost":
                                        option.outcome.add(new EventOutcome_BonusCoreCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_religion_cost":
                                        option.outcome.add(new EventOutcome_BonusReligionCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_advisor_cost":
                                        option.outcome.add(new EventOutcome_BonusAdvisorCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_general_cost":
                                        option.outcome.add(new EventOutcome_BonusGeneralCost(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_disease_death_rate":
                                        option.outcome.add(new EventOutcome_BonusDiseaseDeathRate(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_diplomacy_points":
                                        option.outcome.add(new EventOutcome_BonusDiplomacyPoints(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_battle_width":
                                        option.outcome.add(new EventOutcome_BonusBattleWidth(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_discipline":
                                        option.outcome.add(new EventOutcome_BonusDiscipline(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_manpower_recovery_from_disbanded_army":
                                        option.outcome.add(new EventOutcome_BonusManpowerRecoveryFromADisbandedArmy(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_advisors_max_level":
                                        option.outcome.add(new EventOutcome_BonusAdvisorMaxLevel(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_all_characters_life_expectancy":
                                        option.outcome.add(new EventOutcome_BonusAllCharactersLifeExpectancy(Float.parseFloat(sLine[1])));
                                        break;
                                    case "bonus_regiments_limit":
                                        option.outcome.add(new EventOutcome_BonusRegimentsLimit(Float.parseFloat(sLine[1])));
                                        break;
                                    default:
                                        CFG.LOG(" MISSING IN OPTION -> " + sLine[0] + " *** Line: " + (i + 1));
                                }
                            } else {
                                switch (sLine[0]) {
                                    case "id":
                                        nEvent.id = sLine[1];
                                        break;
                                    case "no_background":
                                        nEvent.no_background = Boolean.parseBoolean(sLine[1]);
                                        break;
                                    case "important":
                                        if(Boolean.parseBoolean(sLine[1])){
                                            nEvent.popUp = true;
                                        }
                                        nEvent.important = Boolean.parseBoolean(sLine[1]);
                                        break;
                                    case "no_text":
                                        nEvent.no_text = Boolean.parseBoolean(sLine[1]);
                                        break;
                                    case "title":
                                        nEvent.title = sLine[1];
                                        break;
                                    case "desc":
                                        nEvent.desc = sLine[1];
                                        break;
                                    case "mission_desc":
                                        nEvent.mission_desc = sLine[1];
                                        break;
                                    case "image":
                                        nEvent.image = sLine[1];
                                        break;
                                    case "only_once":
                                        nEvent.only_once = Boolean.parseBoolean(sLine[1]);
                                        break;
                                    case "possible_to_run":
                                        nEvent.possible_to_run = Boolean.parseBoolean(sLine[1]);
                                        break;
                                    case "show_in_missions":
                                        nEvent.show_in_missions = Boolean.parseBoolean(sLine[1]);
                                        break;
                                    case "mission_image":
                                        nEvent.mission_image = Integer.parseInt(sLine[1]);
                                        break;
                                    case "popUp":
                                        nEvent.popUp = Boolean.parseBoolean(sLine[1]);
                                        break;
                                    case "super_event":
                                        nEvent.super_event = Boolean.parseBoolean(sLine[1]);
                                        break;
                                    case "execute_at":
                                        nEvent.execPosition = Integer.parseInt(sLine[1]);
                                        break;
                                    case "music_file":
                                        nEvent.musicName = sLine[1];
                                        break;
                                    default:
                                        CFG.LOG(" MISSING -> " + sLine[0] + " *** Line: " + (i + 1));
                                }
                            }
                        }
                    } catch (Exception var42) {
                        Exception exr = var42;
                        CFG.exceptionStack(exr);
                    }

                    ++i;
                }
            }
        } catch (Exception var43) {
            Exception ex = var43;
            CFG.exceptionStack(ex);
        }

        return null;
    }

    public static void loadMissionImages() {
        try {
            FileHandle tempFileT = FileManager.loadFile("game/events/imagesMissions/numOfImages.txt");
            int numOfImages = Integer.parseInt(tempFileT.readString());

            for(int i = 0; i < numOfImages; ++i) {
                if (FileManager.loadFile("game/events/imagesMissions/" + CFG.getRescouresPath_Short() + i + ".png").exists()) {
                    missionImages.add(new Image(ImageManager.loadTexture("game/events/imagesMissions/" + CFG.getRescouresPath_Short() + i + ".png"), TextureFilter.Linear, TextureWrap.ClampToEdge));
                } else {
                    missionImages.add(new Image(ImageManager.loadTexture("game/events/imagesMissions/" + CFG.getRescouresPath_Short_H() + i + ".png"), TextureFilter.Linear, TextureWrap.ClampToEdge));
                }
            }
        } catch (Exception var3) {
            Exception ex = var3;
            CFG.exceptionStack(ex);
        }

    }

    public static void loadEventIMG(String sName) {
        if (!sName.equals(loadedEventIMG)) {
            if (eventIMG != null) {
                eventIMG.dispose();
                eventIMG = null;
            }

            try {
                if (FileManager.loadFile("game/events/images/" + CFG.getRescouresPath_Short() + sName).exists()) {
                    eventIMG = new Image(ImageManager.loadTexture("game/events/images/" + CFG.getRescouresPath_Short() + sName), TextureFilter.Linear, TextureWrap.ClampToEdge);
                } else {
                    eventIMG = new Image(ImageManager.loadTexture("game/events/images/" + CFG.getRescouresPath_Short_H() + sName), TextureFilter.Linear, TextureWrap.ClampToEdge);
                }

                loadedEventIMG = sName;
            } catch (Exception var2) {
                Exception ex = var2;
                eventIMG = new Image(ImageManager.loadTexture_RGB888("game/events/images/" + CFG.getRescouresPath_Short() + "default.png"), TextureFilter.Linear, TextureWrap.ClampToEdge);
                CFG.exceptionStack(ex);
            }

        }
    }

    public static class Event_ExactDate {
        public int eventID;
        public int day;
        public int month;
        public int year;

        public Event_ExactDate(int eventID, int day, int month, int year) {
            this.eventID = eventID;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
}
