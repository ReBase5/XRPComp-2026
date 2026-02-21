package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.XRPDrivetrain;

/**
 * Turns the XRP robot approximately 90 degrees to the left by driving
 * along a curve using arcadeDrive with a forward speed and right rotation.
 */
public class PushTurnLeft extends Command {

    private static final double FORWARD_SPEED = 1.4;  // Forward component of the curve
    private static final double ROTATE_SPEED  = 1.4;  // Positive = rotate left
    private static final double TURN_DISTANCE_INCHES = 10.0; // Tune to achieve ~90 degrees

    private final XRPDrivetrain drivetrain;
    private double startDistance;

    public PushTurnLeft(XRPDrivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.resetEncoders();
        startDistance = drivetrain.getRightDistanceInch();
    }

    @Override
    public void execute() {
        // Positive forward + negative rotation curves the robot to the left.
        // The left wheel travels the outer (longer) arc and is used to measure distance.
        drivetrain.arcadeDrive(FORWARD_SPEED, ROTATE_SPEED);
    }

    @Override
    public boolean isFinished() {
        // Left wheel travels the outer arc, so it covers more distance — use it as the trigger
        double distanceTraveled = Math.abs(drivetrain.getRightDistanceInch() - startDistance);
        return distanceTraveled >= TURN_DISTANCE_INCHES;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0, 0);
    }
}