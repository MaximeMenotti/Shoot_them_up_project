package entities;

public interface Entity {
    /**
     * Define the action when an entity is hit
     */
	public void hit();
    
    /**
     * Return a boolean true if the entity is active and false on the other case (not active)
     * @return the active value
     */
	public boolean isActive();
}
