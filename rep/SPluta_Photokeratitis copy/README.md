Photokeratitis (after David Tudor)
Sam Pluta

Photokeratitis is an software interface for a laptop ensemble piece of the same name. The software provides an interface to control a 4 oscillator cross-feedback unit generator operating in oversampling mode. The oscillators are set up so that Oscillator 1 is controlled by Oscillators 2 and 3. Oscillator 2 is controlled by Oscillators 1 and 4. Oscillator 3 is controlled by Oscillators 2 and 4. And Oscillator 4 is controlled by Oscillators 1 and 3. The performer has control of the frequency of each of the 4 oscillators (with the freq sliders), the amount that each modulating oscillator alters the frequency of carrier oscillators (with the mod sliders), and then the shape of each oscillator - 1 = Sin Wave, 2 = Triange Wave, 3 = Square Wave, 4 = Sawtooth Wave.

This cross-feedback system creates a chaotic circuit that does all kinds of unpredictable things when the values are adjusted. The performer can try to understand the circuit or just move sliders around until something sounds interesting enough to save. 

The goal is for each player in the piece to design their own sounds. Each player has 10 slots to save their sounds. When the performer finds a sound that is interesting, they will want to store the setting. The software allows the user to store a setting using a neural network. The neural network actually needs two settings to function. So when the user finds a desirable setting, press the "point1 n" button in a row. Then move the sliders a bit more to find an adjacent setting. When a different desirable setting is found, press the "point2 n" button and then press "train n." Now the neural network will be trained and saved for future use. Recall a setting by pressing the "recall n" button for 1 of the 10 settings saved. The next time the software is opened, all of the trainings made by the performer will be loaded as well, allowing the user to perform straight away without having to make new settings. Sometimes the training will fail and the slider won't interpolate the settings as desired. SORRY! It didn't work. You'll have to do it again.

Performance:

Photokeratitis.makeScore() will make a score for any performance of the piece. New scores should be made every time the piece is played, unless the group becomes particularly fond of any one version. The makeScore method has a number of parameters: 1)number of players, 2)duration of the piece, 3)minimum number of players at any one time, 4)maximum number of performers at any one time, 5)minimum duration of a single player's section, 6)maximum duration of a single player's section, 7)minimum wait between maybe adding a player to the score, 8)maximum wait between maybe adding a player to the score.

The resulting score gives start and stop times for each player as well as which setting to recall in order to play. Each player plays with a timer (or a global timer for everyone to see). Everyone starts their timer at the start of the piece. At the given start time to a section, the player recalls the setting as instructed and unmutes the system. At the stop time, the player mutes the system again and prepares for the next start time. In between starting and stopping the software for a given timeframe, the performer can adjust the "mlp slider" to make the system more musical.

Ideally the performers are spread around the room and the sound of each performer comes from a different speaker in the room. In general, the volume should be relatively loud, but not so loud as to muddy the resulting counterpoint of the system.


---------------------------INSTALLATION INSTRUCTIONS------------------------


Things to do before the software will work. After you do this, you will not have to do it again:

1) ------------------------INSTALL THE LATEST VERSION OF SUPERCOLLIDER
Download and install from here: https://supercollider.github.io/downloads

Open SuperCollider and close it before moving on. This will create the directory we need to put the extensions in.

2) ------------------------DEPENDENCIES

A) ------------------------OVERSAMPLING OSCILLATORS
The software uses the FM7aOS and/or FM7bOS UGens from the OversamplingOscillators plugins. If the user does not have the OversamplingOscillators installed, working plugins can be downloaded from: https://github.com/spluta/OversamplingOscillators/releases/tag/0.0.4

These can also be build from source.

B) ------------------------FLUCOMA LIBRARY
The user must also have the the FluCoMa Library for SuperCollider installed. If this is not already installed on your computer, get that here: https://www.flucoma.org/download/

C) ------------------------THIS FOLDER

Place the 1) Photokeratitis directory, the 2) FluCoMa library and the 3) OverSampling Oscillators library in the following folder:

Mac: Users/"your user name"/Library/Application Support/SuperCollider/Extensions folder
NOTE: This folder is probably hidden. To get to it, in the Finder, go to the Go menu and with the menu open press option on the keyboard. The Library folder should appear.

PC: C:\ProgramData\SuperCollider\Extensions

Once all three folders are in the Extensions folder, mac users need to run the following line in the Terminal:

xattr -cr <and drag the Extensions directory here>

then press return. This should allow your computer to use the plugins.

The PhotokeratitisPlayer file can be moved to anywhere on your computer where it is easy to find. That is all you will need from now on.

Open the PhotokeratitisPlayer file and follow the instructions.