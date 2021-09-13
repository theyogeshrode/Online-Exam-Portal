		const start=1;
		let time=start*60;
		
	
		setInterval(update,1000);
		
		function update()
		{
			const minutes=Math.floor(time/60);
			let seconds=time%60;
				
			document.getElementById("countdown").innerHTML =minutes+":"+seconds;
			if(time>0)
			{
			time--;
			}
			else
			{
				time=0;
			}
			
			if(time==0)
			{
				self.location = "/submit";
			}
		
		}
		