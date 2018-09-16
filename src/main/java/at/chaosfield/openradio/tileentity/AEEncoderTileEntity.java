/**
 * 
package at.chaosfield.openradio.tileentity;
import appeng.api.AEApi;
import appeng.api.exceptions.FailedConnectionException;
import appeng.api.networking.IGridNode;
import appeng.api.networking.ticking.IGridTickable;
import appeng.api.networking.ticking.TickRateModulation;
import appeng.api.networking.ticking.TickingRequest;
import appeng.api.util.AECableType;
import appeng.api.util.AEPartLocation;
import appeng.api.networking.IGridHost;
import appeng.me.cache.helpers.ConnectionWrapper;
import appeng.tile.events.TileEventType;
import appeng.tile.grid.AENetworkTile;


import at.chaosfield.openradio.init.Items;
import at.chaosfield.openradio.interfaces.ILaserAddon;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.DimensionManager;
*/
/**
 * Created by Jakob Riepler (XDjackieXD)
 */
/**
public class AEEncoderTileEntity extends TileEntity implements ILaserAddon, IGridHost, IGridTickable {

    LaserTileEntity laser = null;

    ConnectionWrapper connection;

    AEEncoderTileEntity otherAEEncoder = null;

    @TileEvent(TileEventType.TICK)
    public void onTick() {
        if (!world.isRemote) {
            boolean foundOther = false;
            if (this.laser != null)
                if (!this.laser.isInvalid()) {
                    if(laser.hasNeededComponents() && laser.getItemTier(LaserTileEntity.SLOT_DSP, Items.dspItem) == 3){
                        if(laser.isConnected()){
                            TileEntity other = DimensionManager.getWorld(laser.getOtherLaser().getDim()).getTileEntity(laser.getOtherLaser().getX(), laser.getOtherLaser().getY(), laser.getOtherLaser().getZ());
                            if(other instanceof LaserTileEntity){
                                if(((LaserTileEntity) other).isConnected()){
                                    for(ILaserAddon addon : ((LaserTileEntity) other).getAddons()){
                                        if(addon != null){
                                            if(addon.getTileEntity() instanceof AEEncoderTileEntity){
                                                connectToAEEncoder((AEEncoderTileEntity) addon.getTileEntity());
                                                foundOther = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            if (!foundOther){
                disconnectFromAEEncoder();
            }
        }
    }

    public boolean hasAllRequirenments(){
        return this.laser != null &&
                !this.laser.isInvalid() &&
                laser.hasNeededComponents() &&
                laser.getItemTier(LaserTileEntity.SLOT_DSP, Items.dspItem) == 3 &&
                laser.isConnected();
    }

    private void connectToAEEncoder(AEEncoderTileEntity encoder) {
        this.otherAEEncoder = encoder;

        if (otherAEEncoder != null && otherAEEncoder.getActionableNode() != null && this.getActionableNode() != null) {
            if (!otherAEEncoder.isInvalid() && otherAEEncoder.hasAllRequirenments()) {
                if (this.connection != null && this.connection.connection != null) {
                    final IGridNode a = this.connection.connection.a();
                    final IGridNode b = this.connection.connection.b();
                    final IGridNode sa = this.getActionableNode();
                    final IGridNode sb = otherAEEncoder.getActionableNode();
                    if ((a == sa || b == sa) && (a == sb || b == sb)) {
                        return;
                    }
                }

                try {
                    if (this.connection != null) {
                        if (this.connection.connection != null) {
                            this.connection.connection.destroy();
                            this.connection = new ConnectionWrapper(null);
                        }
                    }

                    if (otherAEEncoder.connection != null) {
                        if (otherAEEncoder.connection.connection != null) {
                            otherAEEncoder.connection.connection.destroy();
                            otherAEEncoder.connection = new ConnectionWrapper(null);
                        }
                    }

                    this.connection = otherAEEncoder.connection = new ConnectionWrapper(AEApi.instance().createGridConnection(this.getActionableNode(), otherAEEncoder.getActionableNode()));
                } catch (FailedConnection e) {
                }
            } else {
                disconnectFromAEEncoder();
            }
        } else {
            disconnectFromAEEncoder();
        }
    }

    private void disconnectFromAEEncoder() {
        this.otherAEEncoder = null;
        if (this.connection != null)
            if (this.connection.connection != null) {
                this.connection.connection.destroy();
                this.connection.connection = null;
            }
        this.connection = null;
    }

    @Override
    public void connectToLaser(LaserTileEntity laser) {
        this.laser = laser;
    }

    @Override
    public void disconnectFromLaser(LaserTileEntity laser) {
        this.laser = null;
    }

    @Override
    public TileEntity getTileEntity() {
        return this;
    }

    @Override
    public String getAddonName(){
        return "aeencoder";
    }

	@Override
	public TickingRequest getTickingRequest(IGridNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TickRateModulation tickingRequest(IGridNode node, int TicksSinceLastCall) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGridNode getGridNode(AEPartLocation dir) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AECableType getCableConnectionType(AEPartLocation dir) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void securityBreak() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void laserConnectionStatusChanged(boolean connected) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getEnergyUsage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TileEntity getTile() {
		// TODO Auto-generated method stub
		return null;
	}
}*/