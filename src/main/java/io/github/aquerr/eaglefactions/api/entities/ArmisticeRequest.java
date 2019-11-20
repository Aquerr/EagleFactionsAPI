package io.github.aquerr.eaglefactions.api.entities;

public class ArmisticeRequest
{
    private String factionName;
    private String enemyFactionName;

    public ArmisticeRequest(String factionName, String enemyFaction)
    {
        this.factionName = factionName;
        this.enemyFactionName = enemyFaction;
    }

    public String getEnemyFactionName()
    {
        return enemyFactionName;
    }

    public String getFactionName()
    {
        return factionName;
    }

    @Override
    public boolean equals (Object removeEnemy)
    {
        if(!(removeEnemy instanceof ArmisticeRequest))
        {
            return false;
        }
        if(removeEnemy == this)
        {
            return true;
        }
        return this.factionName.equals(((ArmisticeRequest) removeEnemy).factionName) && this.enemyFactionName.equals(((ArmisticeRequest) removeEnemy).enemyFactionName);
    }

    @Override
    public int hashCode()
    {
        return factionName.hashCode();
    }
}
