package org.monopoly.Model;

/**
 * Represents the Income Tax Space element on the Game Board's Tiles.
 *
 * @author shifmans
 */
public class IncomeTaxSpace extends GameTile {

    /**
     * Constructor to initialize a IncomeTaxSpace.
     *
     * Developed by: shifmans
     */
    public IncomeTaxSpace() {
        super("Income Tax Space", "");
    }

    /**
     * Shows the actions that occur after a player lands on element space.
     * @return Displays the actions for landing on element space.
     *
     * Developed by: shifmans
     */
    @Override
    public String landOn() {
        actions += payTax();
        return actions;
    }

    /**
     * Player pays $200 tax after landing on element space.
     * @return Instructions for paying tax.
     *
     * Developed by: shifmans
     */
    private String payTax() {
        return "Pay $200";
    }
}
