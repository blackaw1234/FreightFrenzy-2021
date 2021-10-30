package org.firstinspires.ftc.teamcode.autonomous;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.DriveBase;

@Autonomous(name = "CompetitionAuto", group = "first")
public class Competition extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();

    //private DriveBase driveBase = new DriveBase();
    SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
    private DcMotor CarouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");



    @Override
    public void runOpMode() throws InterruptedException {
        //driveBase.init(hardwareMap);
        runtime.reset();

        Trajectory moveForward = drive.trajectoryBuilder(new Pose2d())
            .forward(6)
            .build();

        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectory(moveForward);
    }

}
