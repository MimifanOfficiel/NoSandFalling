package fr.mimifan.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

    }

    @EventHandler
    public void onSandFall(EntityChangeBlockEvent event){
        if(event.getEntityType()== EntityType.FALLING_BLOCK && event.getTo()==Material.AIR){
            if(event.getBlock().getType()==Material.SAND || event.getBlock().getType()==Material.GRAVEL || event.getBlock().getType()==Material.RED_SAND){
                event.setCancelled(true);
                //Update the block to fix a visual client bug, but don't apply physics
                event.getBlock().getState().update(false, false);
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
