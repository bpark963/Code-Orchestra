# **`LINKS`**

---

### `SOFTWARE`

**`ORCA  (programming environment)`**  
`Download at: https://hundredrabbits.itch.io/orca`  
[`https://100r.co/site/orca.html`](https://100r.co/site/orca.html)  
[`https://github.com/Hundredrabbits/Orca`](https://github.com/Hundredrabbits/Orca)

**`PILOT (UDP synthesizer)`**  
`Download at: https://hundredrabbits.itch.io/pilot`  
[`https://wiki.xxiivv.com/site/pilot.html`](https://wiki.xxiivv.com/site/pilot.html)  
[`https://github.com/hundredrabbits/Pilot`](https://github.com/hundredrabbits/Pilot)

**`Ableton Live (DAW)`**  
[`https://www.ableton.com/en/trial/`](https://www.ableton.com/en/trial/)

**`IAC Driver Setup`** [`https://docs.google.com/presentation/d/1JIuJvY_dzRHFgUWG4P5H-6mEgcdG59A9r2V909mQvwA/edit#slide=id.g2a5283b2661_0_71`

### ---

`RESOURCE`

**`Live Coding: A User's Manual`**  
`The first comprehensive introduction to the origins, aspirations, and evolution of live coding.`  
`PDF: https://static.livecodingbook.toplap.org/books/livecoding.pdf`

**`All things live coding`**  
[`https://github.com/toplap/awesome-livecoding/`](https://github.com/toplap/awesome-livecoding/)

**`Hundred Rabbits`**   
`the authors of orca, pilot and more other software.`  
[`https://100r.co/site/about_us.html`](https://100r.co/site/about_us.html)

**`Tidal Cycles`**  
`Live coding environment with Algorithmic patterns`  
[`https://tidalcycles.org/`](https://tidalcycles.org/)

**`Gibber`**  
`A live coding environment for audiovisual performance.`  
[`https://gibber.cc/`](https://gibber.cc/)

**`History of Livecoding_Huichun`**  
[`https://docs.google.com/presentation/d/1_QfMgqrWLL9XSgo3RLfpOERksDRgS-J_O2cgn08kfqY/edit?usp=sharing`](https://docs.google.com/presentation/d/1_QfMgqrWLL9XSgo3RLfpOERksDRgS-J_O2cgn08kfqY/edit?usp=sharing)

---

### `COMMUNITY`

**`TOPLAP`**  
`An organization founded in 2004, to explore and promote live coding.`  
[`https://blog.toplap.org/`](https://blog.toplap.org/)  
[`https://blog.toplap.org/nodes/`](https://blog.toplap.org/nodes/)

**`llllllll.co`**  
`Lines is a Place to Discuss Sound, Process, and Technology.`  
[`https://llllllll.co/`](https://llllllll.co/)

**`ICLC`**  
`The International Conference on Live Coding`  
[`https://iclc.toplap.org`](https://iclc.toplap.org/)

# **`ORCA Operators`**

[`Orca`](https://github.com/Hundredrabbits/Orca?tab=readme-ov-file#Commands) `is an esoteric programming language designed to quickly create procedural sequencers, in which every letter of the alphabet is an operation, where lowercase letters operate on bang, uppercase letters operate each frame. This application is not a synthesizer, but a livecoding environment capable of sending MIDI, OSC & UDP to your audio/visual interfaces, like Ableton, Renoise, VCV Rack or SuperCollider. If you need help, visit the chatroom, join the forum or watch a tutorial.`

**`ORCA Operators`** `Cmd/Ctrl+G`  
`A add(a b): Outputs sum of inputs.`   
`B subtract(a b): Outputs difference of inputs.`   
`C clock(rate mod): Outputs modulo of frame.`   
`D delay(rate mod): Bangs on modulo of frame.`   
`E east: Moves eastward, or bangs.`   
`F if(a b): Bangs if inputs are equal.`   
`G generator(x y len): Writes operands with offset.`   
`H halt: Halts southward operand.`   
`I increment(step mod): Increments southward operand.`   
`J jumper(val): Outputs northward operand.`   
`K konkat(len): Reads multiple variables.`   
`L lesser(a b): Outputs smallest of inputs.`   
`M multiply(a b): Outputs product of inputs.`   
`N north: Moves Northward, or bangs.`   
`O read(x y read): Reads operand with offset.`   
`P push(len key val): Writes eastward operand.`   
`Q query(x y len): Reads operands with offset.`   
`R random(min max): Outputs random value.`   
`S south: Moves southward, or bangs.`   
`T track(key len val): Reads eastward operand.`   
`U uclid(step max): Bangs on Euclidean rhythm.`   
`V variable(write read): Reads and writes variable.`   
`W west: Moves westward, or bangs.`   
`X write(x y val): Writes operand with offset.`   
`Y jymper(val): Outputs westward operand.`   
`Z lerp(rate target): Transitions operand to input.`   
`* bang: Bangs neighboring operands.`   
`# comment: Halts a line. (cmd/ctrl + /)`  
`$ self(cmd): Send a command to Orca.`   
`: midi(channel octave note velocity length): Send a MIDI note.`  
`% mono(channel octave note velocity length): Sends monophonic MIDI note.`  
`! cc(channel knob value): Sends MIDI control change.`  
`? pb(channel value): Sends MIDI pitch bench.`  
`; udp: Send UDP message.`  
`= osc(path): Sends OSC message.`  
`$ self: Sends ORCA command.`

`0   1   2   3   4   5   6   7   8   9   A   B`  
`0   1   2   3   4   5   6   7   8   9   10  11`

`C   D   E   F   G   H   I   J   K   L   M   N`  
`12  13  14  15  16  17  18  19  20  21  22  23`

`O   P   Q   R   S   T   U   V   W   X   Y   Z`  
`24  25  26  27  28  29  30  31  32  33  34  35`

# **`PILOT Commands`**

[`Pilot`](https://github.com/hundredrabbits/pilot) `is a UDP synthesizer. It has 16 voices, and 8 effects. Commands can be entered directly with the input bar, or through UDP via the port 49161. You can send multiple commands at once by using the ; character.` 

**`Commands`**

**`Play`**`: play synth notes. For example, 03C;13E will play a C3 and E3 chord.`

`Command	Channel Octave Note Velocity Length`  
`04C		0	 4	  C	64	  1/16`  
`04Cf		0	 4	  C	127	  1/16`  
`04Cff		0	 4	  C	127	  1 bar`

**`Settings`**`: change the sound of the synth. The settings command format is a channel value between 0-G, a 3 characters long name, followed by four values between 0-G. The possible waveforms are si, 2i, 4i, 8i, tr, 2r, 4r, 8r, sq, 2q, 4q 8q, sw, 2w, 4w, 8w.`

`Command   Channel  Name	       Info`  
`0ENV056f  0	      Envelope	 Set Attack:0.00 Decay:0.33 Sustain:0.40 Release:1.00`  
`1OSCsisq  1	      Oscilloscope	 Set Osc1:Sine Osc2:Square`

**`Effects`**`: applied to all channels. The effect command format is a 3 characters long name, followed by one value between 0-G for wet and depth.`

`Command Operation`  
**`BITff	 Bitcrusher`**		`Reduces audio resolution for a gritty, low-fidelity effect.`  
**`DISff	 Distortion`**		`Adds saturation or clipping for an intense, aggressive tone.`  
**`WAHff	 AutoWah`**		`Automatically modulates a filter, creating a wah-like effect.`  
**`CHEff	 Chebyshev`**		`Produces nonlinear harmonic distortion for unique textures.`  
**`FEEff	 Feedback`**		`Reuses output in the input, creating resonance or layering.`  
**`DELff	 Ping Pong Delay`**	`Alternates echoes between left and right channels.`  
**`TREff	 Tremolo`**		`Modulates volume to create rhythmic fluctuations.`  
**`REVff	 Reverb`**		`Simulates room reflections for spatial depth and ambience.`  
**`PHAff	 Pashor`**		`Creates sweeping, swirling phase modulation effects.`  
**`VIBff	 Vibrato`**		`Modulates pitch subtly for a warbling effect.`  
**`CHOff	 Chorus`**		`Adds detuned, delayed layers for a fuller sound.`  
**`STEff	 StereoWidener`**	`Enhances the stereo field for spaciousness.`  
**`EQUff	 EQ3`**			`Adjusts bass, mid, and treble frequencies.`  
**`COMff	 Compressor`**		`Balances dynamics for consistent volume.`  
**`VOLff	 Volume`**		`Controls overall sound output level.`  
**`LIMff	 Limiter`**		`Caps audio peaks to avoid distortion.`

**`Special`**

`Command  Operation`  
`bpm140	  sets the BPM to 140`  
`renv	  randomizes envelopes`  
`rosc	  randomizes oscillators`  
`refx 	  randomizes effects`  
`reset	  reset all`	

# **`ORCA x PILOT Modules`**

`Orca and Pilot use UDP to communicate. Orca operators are color-highlighted. Copy and paste these modules. Change the parameters and input values. Duplicate the modules as much as you like in your patch.` 

**`Universal logic in Orca:`**

`![][image1]`

`- Orca operate from top to bottom, left to right`  
`- cmd/ctrl /: # comment`  
`- cmd/ctrl I: keep typing`   
`- cmd/ctrl K: send self commands, ie. bpm`

### ---

`SELF COMMAND`

`#bpm#`  
`#or cmd/ctrl k, type bpm#`  
`.D.........`  
`..$bpm:120.`

`#apm:Animates.bpm.speed.to#`  
`..D.....................`  
`...$apm:080.............`

`#Generative.bpm#`

`#.R.......Ra#`  
`#.n2Tab.3X6.#`  
`#.2Xb....Ra.#`  
`#.R4...1X7..#`  
`#D3....R3...#`  
`#.$bpm:176..#`

`#theme color default: 000;7dc;fff#`  
`.D....................`  
`..$color:000;7ff;ffk..`

### ---

`BANG`

`#D:bang.......#`  
`..D2...........`  
`..*;55Cff......`

`#U:euclidean.bang.#`  
`.3U8.......`  
`...;C1C....`

`#F:if.bang..#`  
`#bang if left matches right#`  
`.I5..........`  
`.1F3.........`  
`...;54G......`

### ---

`CALCULATE`

`#A:add.#`  
`#offset#`  
`....2C.....`  
`..D2.0AC...`  
`..*;23C....`

`#turn sharp note to natural note#`  
`cA1..`  
`.dAZ.`  
`..C..`

`#M:multiply#`  
`cA1..`  
`.dAZ.`  
`..CM1`  
`...c.`

`#B:subtract.#`  
`#back n forth#`  
`..4C6............`  
`...3B3...........`  
`..D404TCAFE......`  
`...;33C..........`

`#C:clock.#`  
`#for each 1 frame output frames % 8#`  
`...C......`  
`...0......`

`#for each 1 frame output frames % 5#`  
`...C5.....`  
`...2......`

`#for each 3 frames output frames % 5#`  
`..3C5.....`  
`...4......`

`#I:increment/interval.#`  
`#add 1 step a time up to z#`  
`...I.........`  
`...f.........`

`#add 1 step a time up to 9#`  
`...I9........`  
`...5.........`

`#add 2 steps a time up to 9#`  
`..2I9........`  
`...1.........`

`#R:random#`  
`#random from left min and right max#`  
`aR.`  
`.h.`  
`...`  
`.R9`  
`.7.`

`#Z:Transition#`  
`#type.in.right.inlet#`  
`...Z.................`  
`...0.................`  
`.....................`  
`..5Z.................`  
`...0.................`

### ---

`WRITE`

`#X:write single.#`  
`.22XC..`  
`.......`  
`.D2....`  
`..;66C.`

`#G:write multiple#`  
`223G55C.`  
`........`  
`...D2...`  
`....;55C`

### ---

`STORE`

`#V:variable.#`   
`#orca operates from top to bottom, left to right#`  
`......Va....`  
`............`  
`..aV5.......`  
`......Va....`  
`......5.....`  
`..aV7.......`  
`......Va....`  
`......7.....`

### ---

`READ`

`#T:read one at a time#`  
`#read a row of notes#`  
`...2C4.........`  
`..D214TCAFE....`  
`..*;03A........`

`#Q:read multiple from offset#`  
`#read a sequence#`  
`.....C...........`  
`.D1.305Q..#13A..#`  
`.*;13A....#24A..#`

`..........#13A..#`  
`..........#24A..#`  
`..........#13C..#`  
`..........#24C..#`  
`..........#13C..#`  
`..........#13C..#`

`#K:read multiple at a time#`  
`#read multi variables#`  
`.aRz..Rf..Rf`  
`aVn.bV2.cV5.`  
`............`  
`............`  
`...D23Kabc..`  
`....;34n25..`

`#O:read one from offset#`  
`#read a random value#`  
`3R8.R4........`  
`.3Y31O...qwert`  
`.....p...poiuy`  
`.D1..J...kjhgf`  
`.*;73p...xzasd`

### ---

`JUMP`

`#J:jump v #`  
`.a..`  
`.J..`  
`.a..`

`#Y:jump > #`  
`aYa.`

### ---

`MOVE`

`#EWSN:move H:stop#`  
`#bang from any direction#`  
`#fun but might mess up the patch if remove ;#`  
`....................;.............`  
`..................................`  
`.....................;............`  
`..................................`  
`..................................`  
`..................................`  
`............R.....................`  
`............k4TEWSN...............`  
`..............E......N............`   
`..........7R9.J...................`  
`H..........7.XE...................`  
`W...............W...E...........;.`  
`.;...................S............`  
`..................................`  
`..................................`  
`..................................`  
`..................................`  
`.....................;............`  
`..................................`  
`....................;.............`

### ---

`SEQUENCER`

`#rhythm sequencer.#`  
`.C8.........`  
`.38T*..*....`  
`...*...R....`  
`...;C0cc....`  
`............`  
`.C8.........`  
`.38T.*....*.`  
`.......R....`  
`...;C1cb....`  
`............`  
`.C8.........`  
`.38T....*...`  
`.......R....`  
`...;C2cm....`

`#euclidean rhythm.#`  
`...........`  
`.2Uc..1Rg..`  
`...;C1c4...`  
`...........`  
`.3Ub..1Rg..`  
`...;93ca...`  
`...........`  
`.4Ua..1Rg..`  
`..*;65c3...`

`#notes.sequencer.#`  
`#with variable#`  
`.C5.........`  
`.48TCDEFG...`  
`.aVG........`  
`............`  
`.C7.........`  
`.18TCDEFGAB.`  
`.bVD........`  
`............`  
`..D3..Va....`  
`..*;24G.....`  
`............`  
`..D4..Vb....`  
`..*;53D.....`

`#notes.sequencer.#`  
`#change octave#`  
`..2C.............`  
`...78T22323223...`  
`...5X3...........`  
`.................`  
`..2C8............`  
`...78TCDEFGABC...`  
`.....C...........`  
`.D2..J...........`  
`..;A3C...........`

**`#tracker#`**  
`..aV1.bVg..........`  
`...................`  
`...................`  
`......Vb...........`  
`......g............`  
`....VaJ.......CgR..`  
`..Va1Cg.......cXt..`  
`.D1.4c5Q...#12ap.#.`  
`.*;13dt....#.2cz.#.`  
`...........#12dg.#.`  
`...........#.2du.#.`  
`...........#12ah.#.`  
`...........#12cp.#.`  
`...........#.2di.#.`  
`...........#12co.#.`  
`...........#13cn.#.`  
`...........#13at.#.`  
`...........#.3di.#.`  
`...........#13dm.#.`  
`...........#13dt.#.`  
`...........#13cm.#.`  
`...........#.3aw.#.`  
`...........#13du.#.`

**`#random offset read#`**  
`..1R3...........`  
`...2C7..........`  
`D2.305Q..#13A..#`  
`.;13A....#24Cff#`  
`.........#132..#`  
`.........#24D..#`  
`.........#13E..#`  
`.........#24F..#`  
`.........#13Gff#`

`#random vertical bang#`  
`.R.......`  
`.dC......`  
`..1X*....`  
`.........`  
`...*;73C.`  
`....;63C.`  
`....;74D.`  
`....;64D.`  
`....;74G.`  
`....;63G.`  
`....;75D.`

`#random eastward bang#`  
`.R...............................`  
`.6C..............................`  
`..2XE............................`  
`........;C2A4....................`  
`...........E...;73A69............`  
`...E......E...E........;65D......`  
`.......E;C2F5....................`  
`..................;73D...........`  
`....E...E.................;65D69.`  
`........;C2D6....................`  
`.....................;73F........`

### ---

`MODULATE PILOT`

`#modulate envelop and oscillator#`  
`#j:lowercase letter only bang when being triggered#`  
`....0R4.Rg.....`  
`.....14X7......`  
`.D3............`  
`..;94c55.......`  
`.j.............`  
`.j.............`  
`..;9env478b....`  
`.j......R......`  
`.j......t3Tiqw.`  
`..;9oscsisw....`

`#modulate effects#`  
`#room shrink and expand#`  
`#sound source close and far#`  
`..........2Cu..`  
`...........gBf.`  
`.D1.......zV1..`  
`.*;C2C.........`  
`.j.............`  
`.j.....Vz......`  
`.*;rev11.......`  
`.j.............`  
`.j....Vz.......`  
`.*;del1f.......`

# **`OTHER FUN PATCHES`**

[`https://www.youtube.com/watch?v=VzPmCyDCO5k`](https://www.youtube.com/watch?v=VzPmCyDCO5k)  
`...#Orca...Techno.Practice#...........`  
`......................................`  
`.....#Z:Transition#...................`  
`....#type.in.right.inlet#.............`  
`....#..Z................#.............`  
`....#..0................#.............`  
`....#...................#.............`  
`....#.5Z................#.............`  
`....#..0................#.............`  
`......................................`  
`......................................`  
`...#apm:Animates.bpm.speed.to#........`  
`...#.D.......................#........`  
`...#..$apm:080...............#........`  
`......................................`  
`......................................`  
`.#lower.vs.upper.case.x#..............`  
`.#..C3.D..............#...............`  
`.#..2M3.H.............#...............`  
`.#...6.xS.............#...............`  
`......................................`

[`https://www.youtube.com/watch?v=DBI8eBMGyYs`](https://www.youtube.com/watch?v=DBI8eBMGyYs)  
`.#Generative.Loop...ORCA#.............`  
`#..................................R9#`  
`#...I8.............................5.#`  
`#...3................................#`  
`#R..J.R..............................#`  
`#vYv3Xq..............................#`  
`#....................................#`  
`#.R9.I9..............................#`  
`#.4Y401GE............................#`  
[`https://www.youtube.com/watch?v=tdunjIiroao`](https://www.youtube.com/watch?v=tdunjIiroao)  
`#.Orca...Delay.with.animated.velocity#`  
`......................................`  
`.#create.interval.for.note#...........`  
`......................................`  
`.#............gC6..........#..........`  
`.#.22O.22O.31O.26TCGCBFE...#..........`  
`.#.2AI.3AF.3AC.2AC.........#..........`  
`.#3VK.2VI.1VF.0VE..........#..........`  
`......................................`  
`......................................`  
`......#ocave#..#delay.structure#......`  
`......#..............................#`  
`......#..7.X4..H.23O.................#`  
`......#........*;54..................#`  
`......#..a.X5.....H.23O..............#`  
`......#...........*;55K............V0#`  
`......#..d.X3........H.63O.........E.#`  
`......#..............*;53.....C..V3J.#`  
`......#.......................23TK.E.#`  
`......#.........................E....#`  
`......#..............................#`

[`https://www.youtube.com/watch?v=N-CzNpa5Apk`](https://www.youtube.com/watch?v=N-CzNpa5Apk)  
`#Alicef...Pong#........................`  
`#the.old.version.orca#.................`  
`.......................................`  
`#a.half#.#back.n.forth#................`  
`#.....................................#`  
`#.....................................#`  
`#...Ik.....Ig.........................#`  
`#.aB7....8B9..........................#`  
`#xV3....yV1...........................#`  
`#.....................................#`  
`#...................Vy................#`  
`#.................2A1.................#`  
`#.....2Kxy.........3O.................#`  
`#.......31X*0000000000................#`  
`#........0...........0................#`  
`#........0...*.......0................#`  
`#........0...........0................#`  
`#........0...........0................#`  
`#........0...........0................#`  
`#........0...........0................#`  
`#........0...........0................#`  
`#........0...........0................#`  
`#......Vx............0................#`  
`#......3.O00000000000.................#`  
`#........0............................#`  
`#.....................................#`  
`#.....................................#`  
`#.....Vx......Vx.......Vy.......Vy....#`  
`#.....3Fa.....3F0......1F0......1F8...#`  
`#.......;74D....;73C.....;64G.....;65C#`  
`#.....................................#`  


[image1]: <data:image/png;base64,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>