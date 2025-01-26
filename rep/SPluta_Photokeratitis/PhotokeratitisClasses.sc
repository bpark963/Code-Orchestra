QtEZSliderBurst {

	var <>controlSpec, <>slider, <>numBox, <>label, <>layout;
	var <>round = 0.001;
	var <>action, <value, <>zAction, viewArray;

	*new { arg label, controlSpec, action, initVal,
		initAction=false, orientation=\vert, viewNumberBox=true;

		^super.new.init(label, controlSpec, action, initVal,
			initAction, orientation, viewNumberBox);
	}

	init { arg argLabel, argControlSpec, argAction, initVal, initAction, orientation, viewNumberBox;
		var numberStep;

		viewArray = List.newClear;

		if(argLabel!=nil,{
			label = StaticText();
			label.string = argLabel;
			label.maxHeight_(15).maxWidth_(60).font_(Font("Helvetica", 10));
			viewArray.add(label);

		},{
			label=nil
		});

		slider = Slider();
		slider.maxHeight_(150);
		viewArray.add(slider);

		numBox = NumberBox();
		numBox.maxWidth_(60);
		numBox.maxHeight_(15);
		numBox.font_(Font("Helvetica", 10));
		if(viewNumberBox, {viewArray.add(numBox)});

		zAction = {}; //the default zAction is to do nothing

		switch(orientation,
			\vert, {slider.orientation=\vertical; layout = VLayout(*viewArray)},
			\vertical, {slider.orientation=\vertical; layout = VLayout(*viewArray)},
			\horz, {slider.orientation=\horizontal; layout = HLayout(*viewArray)},
			\horizontal, {slider.orientation=\horizontal; layout = HLayout(*viewArray)});

		// set view parameters and actions

		controlSpec = argControlSpec.asSpec;
		controlSpec.addDependant(this);

		initVal = initVal ? controlSpec.default;
		action = argAction;

		slider.action = {
			this.valueAction_(controlSpec.map(slider.value));
		};

		slider.receiveDragHandler = { arg slider;
			slider.valueAction = controlSpec.unmap(GUI.view.currentDrag);
		};

		slider.beginDragAction = { arg slider;
			controlSpec.map(slider.value)
		};

		numBox.action = { this.valueAction_(numBox.value) };

		numberStep = controlSpec.step;
		if (numberStep == 0) {
			numberStep = controlSpec.guessNumberStep
		}{
			numBox.alt_scale = 1.0;
			slider.alt_scale = 1.0;
		};

		numBox.step = numberStep;
		numBox.scroll_step = numberStep;

		if (initAction) {
			this.valueAction_(initVal);
		}{
			this.value_(initVal);
		};

		if (label.notNil) {
			label.mouseDownAction = {|view, x, y, modifiers, buttonNumber, clickCount|
				if(clickCount == 2, {this.editSpec});
			}
		};

	}

	asView {^layout}

	maxHeight_ {arg val;
		slider.maxHeight_(val)
	}

	maxWidth_ {arg val;
		viewArray.do{arg item;
			item.maxWidth_(val);
		}
	}

	onClose{controlSpec.removeDependant(this)}

	value_ { arg val;
		value = controlSpec.constrain(val);
		{
			numBox.value = value.round(round);
			slider.value = controlSpec.unmap(value);
		}.defer;
	}

	map {arg val;
		^controlSpec.unmap(val);
	}

	valueAction_ { arg val;
		this.value_(val);
		this.doAction;
	}

	doAction { action.value(this) }

	set { arg label, spec, argAction, initVal, initAction = false;
		label.notNil.if { label.string = label.asString };
		spec.notNil.if { controlSpec = spec.asSpec };
		argAction.notNil.if { action = argAction };

		initVal = initVal ? value ? controlSpec.default;

		if (initAction) {
			this.valueAction_(initVal);
		}{
			this.value_(initVal);
		};
	}

	font_{ arg font;

		label.notNil.if{label.font=font};
		numBox.font=font;
	}

}

//4sies
Photokeratitis2 {

	*new { arg server, version=2, outChannel = 0;

		^super.new.init(server, version, outChannel);
	}

	init {|server, version, outChannel|
		{
			var synth, labels, sliders, functionButtons, saveButtons, recallButtons, modSpec, modShape;
			var scopeBuf = Buffer.alloc(server, 1024, 2), win;

			var scopeView = ScopeView().waveColors_([Color.green]).bufnum_(scopeBuf.bufnum).server_(server).minHeight_(250).start;

			server.sync;


			synth = {
				var ctls, mods, chans, sound, initMod;
				ctls = [
					// freq, phase, amp
					\freq1.ar(200),
					\freq2.ar(200),
					\freq3.ar(200),
					\freq4.ar(200)
				];
				if(version == 1){initMod = 250}{initMod=0.25};
				mods = [
					[0, \mod1.ar(initMod), \mod2.ar(initMod), 0],
					[\mod3.ar(initMod), 0, 0, \mod4.ar(initMod)],
					[0,\mod5.ar(initMod), 0, \mod6.ar(initMod)],
					[\mod7.ar(initMod), 0, \mod8.ar(initMod), 0]
				];
				chans = [0,0];
				if(version == 1){
					sound = FM7aOS.ar(ctls, mods, [\osc1.ar(2),\osc2.ar(3),\osc3.ar(3),\osc4.ar(0)], 4).softclip;
				}{
					sound = FM7bOS.ar(ctls, mods, [\osc1.ar(2),\osc2.ar(3),\osc3.ar(3),\osc4.ar(0)], 4).softclip;
				};

				sound = sound[0]*\playMute.kr(0)*\vol.kr(0);
				Out.ar(outChannel,sound.dup);
				ScopeOut2.ar(sound, \scopeBuf.kr(0));

			}.play(server, args:[\scopeBuf, scopeBuf]);

			server.sync;


			if(version == 1){modSpec = 3000}{modSpec=1};
			if(version == 1){modShape = 'exp'}{modShape = 'lin'};

			labels = ["freq1", "freq2", "freq3", "freq4", "mod1", "mod2", "mod3", "mod4", "mod5", "mod6", "mod7", "mod8", "osc1", "osc2", "osc3", "osc4"];
			sliders = labels[0..3].collect{|item, i| QtEZSliderBurst(item, ControlSpec(0.01,4000, 'exp'), {|sl| synth.set(item.asSymbol, sl.value)}, exprand(0.01,4000), true)}
			.addAll(labels[4..11].collect{|item, i| QtEZSliderBurst(item, ControlSpec(0.001,modSpec, modShape), {|sl| synth.set(item.asSymbol, sl.value)}, if(version == 1){exprand(0.01,modSpec)}{rrand(0.1,modSpec)}, true)})
			.addAll(labels[12..15].collect{|item, i| QtEZSliderBurst(item, ControlSpec(0,3,'lin', 1), {|sl| synth.set(item.asSymbol, sl.value)}, rrand(0,3), true)});

			functionButtons = List.newClear(0);
			functionButtons.add(Button()
				.states_([["randomize", Color.black, Color.white], ["randomize", Color.white, Color.black]])
				.action_{|butt|
					sliders.do{|item,i|
						item.valueAction_(item.controlSpec.map(1.0.rand))};
					functionButtons[2].valueAction_(0.125);

				}
			);

			functionButtons.add(Button()
				.states_([["muted", Color.black, Color.red], ["playing", Color.white, Color.green]])
				.action_{|butt|
					if(butt.value==1){synth.set(\playMute, 1)}{synth.set(\playMute,0)};
				}
			);

			functionButtons.add(QtEZSliderBurst("vol", ControlSpec(0,1,'amp'), {|sl| synth.set(\vol, sl.value)}, 0, true, 'horz'));

			saveButtons = List.newClear(0);
			recallButtons = List.newClear(0);

			10.do{|i|
				saveButtons.add(Button().states_([["save"++(i+1), Color.white, Color.blue]])
					.action_{|butt|
						sliders.collect{|item| item.value}.add(functionButtons[2].value).writeArchive(PathName(this.class.filenameSymbol.asString).pathOnly++"data/save"++version++"_"++(i+1));
				});
				recallButtons.add(Button().states_([["recall"++(i+1), Color.white, Color.blue]])
					.action_{|butt|
						var temp = Object.readArchive(PathName(this.class.filenameSymbol.asString).pathOnly++"data/save"++version++"_"++(i+1));
						sliders.do{|item, i| item.valueAction_(temp[i])};
						functionButtons[2].valueAction_(temp.last);
				});
			};

			win = Window("Photokeratitis");
			win.layout = VLayout(
				HLayout(HLayout(*sliders), VLayout(*saveButtons), VLayout(*recallButtons)),
				HLayout(*functionButtons),
				scopeView
			);
			win.front;
			win.onClose_{synth.free; scopeBuf.free;};
			CmdPeriod.add({win.close});

			(0..7).addAll((16..23)).do{|item, i|
				MIDIFunc.cc({arg ...args;
					args.postln;
					sliders[i].valueAction_(sliders[i].controlSpec.map(args[0]/127).poll)
				}, item);
		}}.fork(AppClock)
	}

	*makeScore {arg numPlayers = 8, duration = 600, min_density = 2, max_density = 8, lowDur = 40, highDur = 80;

		var time = 0, playList = (List.newClear(0)!numPlayers).asList;

		var bags = Array.fill(numPlayers, {(1..10).asBag});

		var players = (0..numPlayers-1).asList;

		var playing = (nil!numPlayers).asList;
		var numPlaying = 0;
		var count = 0;
		var coinSeq = Pseq([(0.3!10),(0.4!10),(0.7!5),(0.3!10),(0.5!10),(0.3!10),(0.6!10),(0.5!10),
			(0.7!10),(0.4!10),(0.5!10),(0.7!10),(0.3!10),(0.1!10),(0.2!10)
		].flatten, inf).asStream;

		while {time<duration}{
			time.postln;
			playing = playing.collect{|item, i| var out;
				if(item!=nil){
					if(item[2]>time){out = item}{out = nil}
				}{out = nil};
				out
			};

			numPlaying = playing.count({|item| item!=nil});
			playing.postln;
			numPlaying.postln;
			if ((time==0)||(numPlaying<max_density))
			{
				count = count+1;
				if((numPlaying<min_density)||0.3.coin||(numPlaying==6)){
					var player = playing.collect{|item,i| if(item==nil){i}{nil}}.select{arg item; (item!=nil)}.choose;
					var choice = bags[player].choose;
					players.remove(player);
					if(players.size<1){players = (0..numPlayers-1).asList};
					bags[player].remove(choice);

					//if(bags[player].size==0){bags[player] = (1..10).asBag};

					playing.put(player, [choice, time, time+rrand(lowDur,highDur)]);

					numPlaying.postln;
					playList[player].add([playing[player][0], this.toTimeString(playing[player][1]), this.toTimeString(playing[player][2])]);
				}
			};
			time = time+rrand(2,7);
		};

		playList.do{|item, i|

			("Player Number "++(i+1)++": ").post;
			item.do{|sub,i|
				var insert="";
				if(sub[0]<10){insert = " "};
				sub.post; insert.post; if(i!=(item.size-1)){", ".post}};
			"".postln;
		};

	}

	*toTimeString { |num, precision = 0.001, maxDays = 365, dropDaysIfPossible = true, decimalPlaces = 3|
		var number, decimal, days, hours, minutes, seconds, mseconds, msecstr, splitstr, isNegative;

		// min value of precision depends on decimalPlaces
		decimalPlaces = decimalPlaces.asInteger.max(0);
		precision = max(precision, 10.pow(decimalPlaces.neg));

		number = num;

		isNegative = number < 0;
		number = number.abs;
		decimal = number.asInteger;

		minutes = (decimal.div(60) % 60).asString.padLeft(2, "0").add($:);
		seconds = (decimal % 60).asString.padLeft(2, "0");

		^minutes ++ seconds
	}
}

Photokeratitis : Photokeratitis2 {
	init {|server, version, outChannel = 0|
		{
			var synth, labels, sliders, functionButtons, saveButtons, recallButtons, modSpec, modShape, point1Buttons, point2Buttons, trainButtons, nnControls;
			var scopeBuf = Buffer.alloc(server, 1024, 2), win;

			var scopeView = ScopeView().waveColors_([Color.green]).bufnum_(scopeBuf.bufnum).server_(server).minHeight_(250).start;

			var mlps = Array.fill(10, {FluidMLPRegressor(server, [3,6,9,15], learnRate:0.1, batchSize:1, validation:0)});
			var dataSetsIn = Array.fill(10, {FluidDataSet(server)});
			var dataSetsOut = Array.fill(10, {FluidDataSet(server)});
			var inBuff1 = Buffer.alloc(server,1);
			var inBuff2 = Buffer.alloc(server,1);
			var outBuff = Buffer.loadCollection(server,{rrand(0.0,1.0)} ! 17);
			var outBuff2 = Buffer.loadCollection(server,{rrand(0.0,1.0)} ! 17);
			var predictBuffIn = Buffer.loadCollection(server,{rrand(0.0,1.0)}!1);
			var predictBuffOut = Buffer.loadCollection(server,{rrand(0.0,1.0)} ! 17);
			var allVals = Array.fill(17,{0.0});
			var mlpButtons, currentMLP=0, predicting = false;

			if(version!=1){version=2};

			10.do{|i|
				var filename = PathName(this.class.filenameSymbol.asString).pathOnly++"data/mlp"++version++"_"++(i+1);
				if(PathName(filename).isFile){
					mlps[i].read(filename);
				};
			};

			inBuff1.setn(0,[0.0]);
			inBuff2.setn(0,[1.0]);

			server.sync;
			10.do{|i|
				dataSetsIn[i].setPoint('1', inBuff1);
				dataSetsIn[i].setPoint('2', inBuff2);
			};
			server.sync;


			synth = {
				var ctls, mods, chans, sound, initMod;
				ctls = [
					// freq, phase, amp
					\freq1.ar(200),
					\freq2.ar(200),
					\freq3.ar(200),
					\freq4.ar(200)
				];
				if(version == 1){initMod = 250}{initMod=0.25};
				mods = [
					[0, \mod1.ar(initMod), \mod2.ar(initMod), 0],
					[\mod3.ar(initMod), 0, 0, \mod4.ar(initMod)],
					[0,\mod5.ar(initMod), 0, \mod6.ar(initMod)],
					[\mod7.ar(initMod), 0, \mod8.ar(initMod), 0]
				];
				chans = [0,0];
				if(version == 1){
					sound = FM7aOS.ar(ctls, mods, [\osc1.ar(2),\osc2.ar(3),\osc3.ar(3),\osc4.ar(0)], 4).softclip;
				}{
					sound = FM7bOS.ar(ctls, mods, [\osc1.ar(2),\osc2.ar(3),\osc3.ar(3),\osc4.ar(0)], 4).softclip;
				};

				sound = sound[0]*\playMute.kr(0)*\vol.kr(0);
				Out.ar(outChannel, sound.dup);
				ScopeOut2.ar(sound, \scopeBuf.kr(0));

			}.play(server, args:[\scopeBuf, scopeBuf]);

			server.sync;


			if(version == 1){modSpec = 3000}{modSpec=1};
			if(version == 1){modShape = 'exp'}{modShape = 'lin'};

			labels = ["freq1", "freq2", "freq3", "freq4", "mod1", "mod2", "mod3", "mod4", "mod5", "mod6", "mod7", "mod8", "osc1", "osc2", "osc3", "osc4"];
			sliders = labels[0..3].collect{|item, i|
				QtEZSliderBurst(item, ControlSpec(0.01,4000, 'exp'), {|sl|
					synth.set(item.asSymbol, sl.value);
					allVals.put(i, sl.slider.value);
					//allVals.postln;
					//outBuff.setn(0, allVals);
			}, exprand(0.01,4000), true);}

			.addAll(labels[4..11].collect{|item, i|
				QtEZSliderBurst(item, ControlSpec(0.01,modSpec, 'exp'), {|sl|
					synth.set(item.asSymbol, sl.value);
					allVals.put(i+4, sl.slider.value);
					//allVals.postln;
					//outBuff.setn(0, allVals);
			}, if(version == 1){exprand(0.01,modSpec)}{rrand(0.1,modSpec)}, true)})

			.addAll(labels[12..15].collect{|item, i|
				QtEZSliderBurst(item, ControlSpec(0,3,'lin', 1), {|sl|
					synth.set(item.asSymbol, sl.value);
					allVals.put(i+12, sl.slider.value);
					//allVals.postln;
					//outBuff.setn(0, allVals);
				}, rrand(0,3), true)
			});


			functionButtons = List.newClear(0);
			functionButtons.add(Button()
				.states_([["randomize", Color.black, Color.white], ["randomize", Color.white, Color.black]])
				.action_{|butt|
					sliders.do{|item,i|
						item.valueAction_(item.controlSpec.map(1.0.rand))};
					functionButtons[2].valueAction_(0.5);

				}
			);

			functionButtons.add(Button()
				.states_([["muted", Color.black, Color.red], ["playing", Color.white, Color.green]])
				.action_{|butt|
					if(butt.value==1){synth.set(\playMute, 1)}{synth.set(\playMute,0)};
				}
			);

			functionButtons.add(QtEZSliderBurst("vol", ControlSpec(0,1,'amp'), {|sl|
				allVals.put(16, sl.value);
				//outBuff.setn(0, allVals);
				synth.set(\vol, sl.value)
			}, 0, true, 'horz'));

			mlpButtons = List.newClear(0);

			mlpButtons.add(QtEZSliderBurst("mlp slider", ControlSpec(0,1,'lin'), {|sl|
				predictBuffIn.setn(0,[sl.value]);
				if(predicting.not){
					predicting = true;
					mlps[currentMLP].predictPoint(predictBuffIn, predictBuffOut, {|buff|
						predicting = false;
						buff.loadToFloatArray(action:{|array|
							//array.postln;
							sliders.do{|sl,i|
								if(array[i]!=nil)
								{{sl.valueAction_(sl.controlSpec.map(array[i]))}.defer}
							};
							{functionButtons[2].valueAction_(array[16])}.defer;
						});
					})
				};
			}, 0, false, 'vert'));

			saveButtons = List.newClear(0);
			recallButtons = List.newClear(0);
			point1Buttons = List.newClear(0);
			point2Buttons = List.newClear(0);
			trainButtons = List.newClear(0);


			10.do{|i|
				/*		saveButtons.add(Button().states_([["save"++i, Color.white, Color.blue]])
				.action_{|butt|
				sliders.collect{|item| item.value}.add(functionButtons[2].value).writeArchive(Document.current.dir+/+"data/save"++i);
				currentMLP = i;
				});*/
				recallButtons.add(Button().states_([["recall"++i, Color.white, Color.blue], ["recall"++i, Color.blue, Color.white]])
					.action_{|butt|
						recallButtons.do{|item, i2|
							if(i2 == i){item.value_(1)}{item.value_(0)}
						};
						mlps[i].read(PathName(this.class.filenameSymbol.asString).pathOnly++"data/mlp"++version++"_"++(i+1));
						currentMLP = i;
						mlpButtons[0].valueAction_(0);
				});

				point1Buttons.add(Button().states_([["point1 "++i, Color.green, Color.white], ["point1 "++i, Color.black, Color.magenta]])
					.action_{|butt|
						point1Buttons.do{|item, i2|
							if(i2 == i){item.value_(1)}{item.value_(0)}
						};
						{
							inBuff1.setn(0,[0.0]);
							outBuff.setn(0, allVals);
							server.sync;
							dataSetsOut[i].setPoint('1', outBuff);
							dataSetsIn[i].setPoint('1', inBuff1);
						}.fork;
				});
				point2Buttons.add(Button().states_([["point2 "++i, Color.green, Color.white], ["point1 "++i, Color.black, Color.magenta]])
					.action_{|butt|
						point2Buttons.do{|item, i2|
							if(i2 == i){item.value_(1)}{item.value_(0)}
						};
						{
							inBuff2.setn(0,[1.0]);
							outBuff2.setn(0, allVals);
							server.sync;
							dataSetsOut[i].setPoint('2', outBuff2);
							dataSetsIn[i].setPoint('2', inBuff2);
						}.fork;

				});
				trainButtons.add(Button().states_([["train "++i, Color.white, Color.green]])
					.action_{|butt|
						if(point1Buttons[i].value==1&&point2Buttons[i].value==1)
						{
							point1Buttons[i].value_(0);
							point2Buttons[i].value_(0);
							dataSetsIn[i].dump;
							dataSetsOut[i].dump;
							mlps[i].clear({
								mlps[i].fit(dataSetsIn[i], dataSetsOut[i], {|error|
									"current error: % ".format(error.round(0.0001)).post;
									{"*".post} ! (error * 100).asInteger;
									"".postln;
									mlps[i].write(PathName(this.class.filenameSymbol.asString).pathOnly++"data/mlp"++version++"_"++(i+1));
									currentMLP = i;
									{recallButtons.do{|item, i2|
										if(i2 == currentMLP){item.value_(1)}{item.value_(0)}
									}}.defer;
								});
							});
						}

				});
			};

			win = Window("");
			win.layout = VLayout(
				HLayout(HLayout(*sliders)/*, VLayout(*saveButtons)*/, VLayout(*recallButtons), VLayout(*point1Buttons), VLayout(*point2Buttons), VLayout(*trainButtons), HLayout(*mlpButtons)),
				HLayout(*functionButtons),
				scopeView.minHeight_(300)
			);


			win.front;
			win.onClose_{synth.free; scopeBuf.free;};
			CmdPeriod.add({win.close});

			(0..7).addAll((16..23)).do{|item, i|
				MIDIFunc.cc({arg ...args;
					args.postln;
					sliders[i].valueAction_(sliders[i].controlSpec.map(args[0]/127).poll)
				}, item);
		}}.fork(AppClock)
	}
}