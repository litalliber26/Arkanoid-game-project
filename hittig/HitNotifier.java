package hittig;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-05-24
 */

/**
 * The HitNotifier interface indicate that objects that implement it send
 * notifications when they are being hit.
 */
public interface HitNotifier {
    // Add hl as a listener to hit events.
    /**
     * The function add hl as a listener to hit events.
     * @param hl listener to hit events.
     */
    void addHitListener(HitListener hl);
    // Remove hl from the list of listeners to hit events.
    /**
     * The function remove hl from the list of listeners to hit events.
     * @param hl listener to hit events.
     */
    void removeHitListener(HitListener hl);
}