import React from 'react';
import FeatureCard from './FeatureCard';
import { LuHandshake } from "react-icons/lu";
import { GoRocket } from "react-icons/go";
import { IoCreateOutline } from "react-icons/io5";
import ProfileCard from './ProfileCard';
import { motion } from "framer-motion";
import {
  Accordion,
  AccordionContent,
  AccordionItem,
  AccordionTrigger,
} from "@/components/ui/accordion";
import { useNavigate } from 'react-router-dom';
import Navbar from './Navbar';

const LandingPage = () => {

  const matchedPairs = [
    {
      person1: { name: 'Daniel', role: 'Developer' },
      person2: { name: 'Kevin', role: 'Marketer' }
    },
    {
      person1: { name: 'Keisa', role: 'Developer' },
      person2: { name: 'João', role: 'Marketer' }
    },
    {
      person1: { name: 'Raghu', role: 'Developer' },
      person2: { name: 'Cy', role: 'Marketer' }
    },
    {
      person1: { name: 'Tovi', role: 'Developer' },
      person2: { name: 'Sarah', role: 'Marketer' }
    },
    {
      person1: { name: 'Tovi', role: 'Developer' },
      person2: { name: 'Sarah', role: 'Marketer' }
    },
    {
      person1: { name: 'Tovi', role: 'Developer' },
      person2: { name: 'Sarah', role: 'Marketer' }
    }
  ];
  const navigate = useNavigate()
  const spec = ["Backend", "Frontend", "API's"];
  return (
    <>
      <Navbar />
      <div className='px-4 sm:px-6 lg:px-8 pt-24 sm:pt-32 lg:pt-40'>
        <section className='mb-20 mt-10'>
          <div className='flex flex-col justify-center items-center text-center'>
            <h2 className='text-3xl sm:text-4xl lg:text-5xl font-bold px-4'>
              Tired of Hustling Alone?
            </h2>
            <h2 className='text-3xl sm:text-4xl lg:text-5xl font-bold px-4 mt-2'>
              Find your perfect partner within
            </h2>
            <h2 className='text-3xl sm:text-4xl lg:text-5xl mt-3 bg-gradient-to-r from-yellow-400 to-yellow-500 text-white font-bold rounded-full pb-4 px-4 py-2'>
              Swipes
            </h2>
          </div>
        </section>

        <section id='how-it-works' className='mb-20'>
          <div className='flex gap-5 flex-col justify-center items-center'>
            <h2 className='text-3xl sm:text-4xl lg:text-5xl font-bold text-center'>
              How it Works?
            </h2>
            <div className='grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6 sm:gap-7 w-full max-w-6xl px-4'>
              <FeatureCard
                icon={<IoCreateOutline />}
                title="Create"
                description="Create your profile within minutes."
              />
              <FeatureCard
                icon={<LuHandshake />}
                title="Match"
                description="Swipe and match 130+ dedicated profiles like you would on Tinder."
              />
              <FeatureCard
                icon={<GoRocket />}
                title="Start"
                description="Start working together"
              />
            </div>
          </div>
        </section>

        <section id='partners' className='mb-20'>
          <div className='flex flex-col justify-center items-center mb-7'>
            <h1 className='text-2xl sm:text-3xl lg:text-4xl font-bold text-center px-4'>
              Your Perfect Match is Here
            </h1>
          </div>
          <div className="relative w-full overflow-hidden py-4">
            <motion.div
              className="flex gap-4 sm:gap-6 lg:gap-8"
              animate={{
                x: ["0%", "-100%"]
              }}
              transition={{ ease: "linear", duration: 10, repeat: Infinity }}
            >
              <div className='flex shrink-0 gap-4 sm:gap-6'>
                <ProfileCard
                  name="Danial"
                  role="Developer"
                  about="I'm a web developer with 15+ years of experience in building platforms. I specialize in automations and API integrations"
                  vision="Building innovative, automation-driven solutions that simplify workflows, boost productivity, and create scalable growth"
                  spec={["mobile", "backend", "api's"]}
                  avail="Part-Time"
                />
                <ProfileCard name="Amit" role="Marketer" about="I am the Founder and we help businesses manage customer interactions effectively through voice AI agents. " vision="I have already built few SaaS and my vision is to create something which is for future." spec={["growth", "seo"]} avail="Full-Time"
                />

                <ProfileCard name="Riya" role="Developer" about="I am a full stack developer with 2+ years experience with Next.js. I find passion in providing value through SaaS." vision="I build impactful solutions with an innovative edge, love collaborating with marketers, and thrive on scaling big ideas." spec={["ui/ux", "backend", "devops"]} avail="Part-Time" />

                <ProfileCard name="Manoj" role="Marketer" about="I'm a marketer with more than 10 years of experience in Influencer, meme, creative and digital marketing." vision="I want to leverage data-driven strategies and innovative marketing approaches for exceptional growth." spec={["growth", "brand", "social-media"]} avail="Full-Time" />

                <ProfileCard name="Subhash" role="Developer" about="Experienced Full Stack developer. I have developed several websites, mobile application using React and SpringBoot" vision="Connect with 25 founders to help them build them mvps.Connect with marketers to sell my ready to go to market products." spec={["frontend", "backend", "full-stack"]} avail="Full-Time" />

                <ProfileCard name="Adam" role="Marketer" about="Experienced Community Manager with 4+ years of expertise in building and engaging large online gaming communities." vision="My specialty lies in facilitating environments to increase retention, alleviate support cost and much more! " spec={["growth", "sales", "research"]} avail="Part-Time" />
              </div>
            </motion.div>
          </div>
        </section>

        <section id='FAQ' className='mb-20'>
          <div className='flex flex-col items-center justify-center'>
            <h1 className='text-2xl sm:text-3xl lg:text-4xl font-bold mb-6 text-center px-4'>
              Frequently Asked Questions
            </h1>
            <Accordion
              type="single"
              collapsible
              className="w-full max-w-3xl px-4 sm:px-6 flex flex-col gap-4"
            >
              <AccordionItem value="item-1">
                <AccordionTrigger className="text-lg sm:text-xl hover:bg-yellow-50 rounded-full px-3">
                  Why to choose FlowHive?
                </AccordionTrigger>
                <AccordionContent className="px-3">
                  You can use social media to get a perfect partner for your work. However, it will take longer and sometimes it just down your morale.
                </AccordionContent>
              </AccordionItem>
              <AccordionItem value="item-2">
                <AccordionTrigger className="text-xl hover:bg-yellow-50 rounded-full px-3">Who all can use it?</AccordionTrigger>
                <AccordionContent className="px-3">
                  It can be used by students,developers and marketers who needs a partner for their work.
                </AccordionContent>
              </AccordionItem>
              <AccordionItem value="item-3">
                <AccordionTrigger className="text-xl hover:bg-yellow-50 rounded-full px-3">Why we trust FlowHive?</AccordionTrigger>
                <AccordionContent className="px-3">
                  Every profile is carefully evaluated by our team to ensure its authenticity and trustworthiness.
                </AccordionContent>
              </AccordionItem>
            </Accordion>
          </div>
        </section>

        <section className='mb-20'>
          <div className='flex justify-center items-center flex-col gap-4 sm:gap-5 px-4 text-center'>
            <h1 className='text-2xl sm:text-3xl lg:text-4xl font-bold'>
              Ready to get started?
            </h1>
            <p className='text-lg sm:text-xl text-gray-600'>
              Join us today to find your perfect match
            </p>
            <button
              onClick={() => navigate("/signup")}
              className='border px-8 sm:px-16 py-2 sm:py-3 rounded-2xl bg-yellow-500 hover:bg-yellow-400 text-white font-bold text-lg sm:text-xl transition-colors'
            >
              Start matching
            </button>
          </div>
        </section>
      </div>
    </>
  );
};
export default LandingPage;